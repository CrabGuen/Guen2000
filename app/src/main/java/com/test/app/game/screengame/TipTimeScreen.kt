package com.test.app.game.screengame

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.unit.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import com.test.app.game.R
import java.text.NumberFormat

@Composable
fun TipTimeScreen(navController: NavController) {

    BackHandler {
        navController.popBackStack()
    }

    val amountInput = remember { mutableStateOf("0") }
    val tipInput = remember { mutableStateOf("0") }
    // Chuyển String thành Double, ?: để trả về giá trị 0.0 khi có null
    val amount = amountInput.value.toDoubleOrNull() ?: 0.0
    val tipPercent = tipInput.value.toDoubleOrNull() ?: 0.0
    // Di chuyển tiêu điểm đến và xóa tiêu điểm
    val focusManager = LocalFocusManager.current
    // Đặt biến cho Switch (Làm tròn tip)
    var roundUp by remember { mutableStateOf(false) }
    // Gọi lệnh calculateTip
    val tip = calculateTip(amount, tipPercent, roundUp)

    var boxColor by remember { mutableStateOf(Color.Black) }

    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .padding(32.dp),
        // Thêm không gian 8dp giữa các thành phần con
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            fontSize = 24.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))
        // Tạo textField để nhập thông tin
        TextField(
            value = amountInput.value,
            // Biến it chứa giá trị của amountInput.value
            onValueChange = { amountInput.value = it },
            // Tên khung nhập dữ liệu
            label = { Text(stringResource(R.string.bill_amount)) },
            modifier = Modifier.fillMaxWidth(),
            // Nén hộp văn bản thành 1 dòng có thể cuộn chiều ngang trong nhiều dòng
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                // Bàn phím nhập chỉ có số
                keyboardType = KeyboardType.Number,
                // Hoàn thành thao tác nhập và chuyển sang hộp văn bản tiếp theo
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                // Di chuyển tiêu điểm từ Bill xuống Tip
                onNext = { focusManager.moveFocus(FocusDirection.Down) }
            )
        )
        TextField(
            value = tipInput.value,
            onValueChange = { tipInput.value = it },
            label = { Text(stringResource(R.string.how_was_the_service)) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                // Cho biết user đã nhập xong dữ liệu
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                // Xóa tiêu điểm khỏi vị trí hiện tại
                onDone = { focusManager.clearFocus(true) }
            )
        )
        // Hiển thị hàng Round up tip? (Làm tròn tiền tip?)
        RoundTheTipRow(roundUp = roundUp, onRoundUpChanged = { roundUp = it })
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            // Dùng tip để hiện số tiền boa, gọi là định dạng vị trí
            text = stringResource(R.string.tip_amount, tip),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = boxColor, shape = RoundedCornerShape(100))
                .padding(8.dp)
                .height(56.dp)
                .clickable(interactionSource = interactionSource, indication = null) {
                    navController.navigate("options")
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Crab Guen",
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(24.dp))

        boxColor = if (amount == 222.22 && tipPercent == 22.06) {
            Color.Blue
        } else {
            Color.White
        }
    }
}
private fun calculateTip(
    amount: Double,
    tipPercent: Double = 15.0,
    roundUp: Boolean
): String {
    var tip: Double = tipPercent / 100 * amount
    // Xác định roundUp là true thì truyền hàm tip làm đối số
    if (roundUp)
        tip = kotlin.math.ceil(tip)
    // Định dạng số dưới dạng đơn vị tiền tệ
    return NumberFormat.getCurrencyInstance().format(tip)
}
@Composable
fun RoundTheTipRow(
    roundUp: Boolean,
    onRoundUpChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .size(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = stringResource(R.string.round_up_tip))
        Switch(
            checked = roundUp,
            onCheckedChange = onRoundUpChanged,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End),
            colors = SwitchDefaults.colors(
                uncheckedThumbColor = Color.DarkGray
            )
        )
    }
}