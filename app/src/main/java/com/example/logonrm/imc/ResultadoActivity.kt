package com.example.logonrm.imc

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import com.example.logonrm.imc.extensions.format
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {

    fun setaImagem(resourceId: Int){
        ivStatusImc.setImageDrawable(ContextCompat.getDrawable(this, resourceId))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        if(intent.extras != null){
            val peso   = intent.getStringExtra("PESO").toDouble()
            val altura = intent.getStringExtra("ALTURA").toDouble()

            val imc: Double = peso / (altura * altura)

            tvImc.text = imc.format(1)

            /* when(imc){

               in 0..18 ->{
                   tvStatusImc.text = "Abaixo do Peso"
                   ivStatusImc.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.abaixo))
               }
              }
               */

                if(imc < 18.5){
                    tvStatusImc.text = "Abaixo do Peso"
                    setaImagem(R.drawable.abaixo)
                } else if( imc < 24.9){
                    tvStatusImc.text = "Peso ideal"
                    setaImagem(R.drawable.ideal)
                } else if( imc < 29.9){
                    tvStatusImc.text = "Levemente acima"
                    setaImagem(R.drawable.sobre)
                } else if( imc < 34.9){
                    tvStatusImc.text = "Obesidade"
                    setaImagem(R.drawable.obesidade)
                } else if( imc < 39.9){
                    tvStatusImc.text = "Obesidade"
                    setaImagem(R.drawable.obesidade)
                } else {
                    tvStatusImc.text = "Obesidade"
                    setaImagem(R.drawable.obesidade)
                }
            }
        }
}
