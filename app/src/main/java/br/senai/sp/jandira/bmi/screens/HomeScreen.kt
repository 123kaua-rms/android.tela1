package br.senai.sp.jandira.bmi.screens

import android.text.style.BackgroundColorSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.horizontalGradient(
                listOf(
                    Color(0xFFFFB400),
                    Color(0xFFFF0000),
                    Color(0xFFFFB400)

                )
            )
        )
    ){
        Column (modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Image(
                painter = painterResource(
                    R.drawable.moto
                ),
                contentDescription = stringResource(
                    R.string.logo
                ),
                modifier = Modifier
                    .padding(top = 30.dp)

            )
            Text(
                text = stringResource(
                    R.string.welcome,

                ),
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp),


                shape = RoundedCornerShape(
                    topStart = 40.dp,
                    topEnd = 40.dp
                ),
                colors = CardDefaults
                    .cardColors(
                        contentColor = Color.Black
                    ),
            )
            {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                    ){
                       Text(
                           text = stringResource(
                               R.string.your_name

                           ),
                           fontSize = 25.sp,

                       )
                        TextField(
                            value = "",
                            onValueChange ={},
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                    Button(
                        onClick = {
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Blue
                        ),
                        modifier = Modifier
                            .padding(top= 30.dp),
                        shape = RoundedCornerShape(8.dp)

                    ) {
                        Text(
                            text = stringResource(
                                R.string.next
                            ),
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    }

                Spacer(modifier = Modifier.height(16.dp))



                }
            }
        }
    }



@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}