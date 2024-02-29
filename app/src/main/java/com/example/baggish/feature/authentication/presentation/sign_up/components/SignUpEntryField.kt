import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.baggish.feature.authentication.common.TextFieldKeyboardType

@Composable
fun SignUpEntryField(
    modifier: Modifier = Modifier,
    label: String = "",
    value: String = "",
    isError: Boolean = false,
    onValueChange: (String)->Unit,
    textFieldKeyboardType: TextFieldKeyboardType = TextFieldKeyboardType.TEXT,
    suffix: @Composable() (()->Unit)?= null
){
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        singleLine = true,
        modifier = modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        keyboardOptions = when (textFieldKeyboardType) {
            TextFieldKeyboardType.PASSWORD -> KeyboardOptions(keyboardType = KeyboardType.Password)
            TextFieldKeyboardType.EMAIL -> KeyboardOptions(keyboardType = KeyboardType.Email)
            else -> KeyboardOptions(keyboardType = KeyboardType.Text)
        },
        visualTransformation = if (textFieldKeyboardType == TextFieldKeyboardType.PASSWORD)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        suffix = suffix,
        isError = isError
    )
}