package br.senai.sp.jandira.bmi.screens

import android.service.autofill.UserData
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun UserDataScreen() {
    var selectedGender by remember { mutableStateOf<String?>(null) }
    var age by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }

    Box(
        modifier = Modifier

            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    listOf(Color(0xFFFFC420),
                        Color(0xFFF80000),
                                Color(0xFFFFC420)
                    )
                )
            )
    )
    {
        Text(
            text = "Hi!",
            color = Color.Black,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 100.dp, start = 15.dp)
                .fillMaxSize()



        )
        Column(
            modifier = Modifier
                .fillMaxSize(),

            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {




            Card(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(1.dp)
                    .height(600.dp),




                        shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,


                ) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {
                        GenderOption(
                            icon = R.drawable.homem,
                            text = "masculino",
                            isSelected = selectedGender == "masculino"
                        ) { selectedGender = "masculino" }

                        GenderOption(
                            icon = R.drawable.mulher,
                            text = "Feminino",
                            isSelected = selectedGender == "Feminino"
                        ) { selectedGender = "Feminino" }
                    }

                    Spacer(modifier = Modifier.height(16.dp))


                    InputField(value = age, label = "Idade") { age = it }
                    InputField(value = weight, label = "Altura") { weight = it }
                    InputField(value = height, label = "Peso") { height = it }

                    Spacer(modifier = Modifier.height(24.dp))

                    Button(
                        onClick = { },
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF0000))
                    ) {
                        Text(text = "Calculate", fontSize = 20.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

@Composable
fun GenderOption(icon: Int, text: String, isSelected: Boolean, onSelect: () -> Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = icon),
            contentDescription = text,
            modifier = Modifier
                .size(80.dp)
                .background(
                    color = if (isSelected) Color.Magenta else Color.Transparent,
                    shape = CircleShape
                )
                .clickable { onSelect() }
        )
        Button(
            onClick = { onSelect() },
            colors = ButtonDefaults.buttonColors(
                containerColor = if (isSelected) Color.Blue else Color.Gray
            )
        ) {
            Text(text = text, color = Color.White)
        }
    }
}

@Composable
fun InputField(value: String, label: String, onValueChange: (String) -> Unit) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        modifier = Modifier.fillMaxWidth()
    )
}


@Preview(showSystemUi = true)
@Composable
private fun UserDataScreenPreview() {
    UserDataScreen()
}
