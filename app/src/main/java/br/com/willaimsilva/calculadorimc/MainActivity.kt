package br.com.willaimsilva.calculadorimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.com.willaimsilva.calculadorimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var alertDialog: AlertDialog.Builder
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.count.setOnClickListener {
            if (binding.TxAltura.text.toString().toFloatOrNull() == null) {

                Toast.makeText(MainActivity@ this, "digite um numero", Toast.LENGTH_SHORT).show()


            } else {
                var peso = binding.TxPeso.text.toString().toInt()
                var altura = binding.TxAltura.text.toString().toFloat()
                var imc = peso / (altura * altura)

                //mesmo modo porem mais inteligente

                //imc= (peso/ Math.pow(altura.toDouble(),2.0)).toFloat()





                if (binding.RgGenero.checkedRadioButtonId == R.id.RbMasculino) {

                    val resultado = when {

                        imc >= 31.1f -> " que é considerado obesidade"
                        imc >= 24.99f -> " que é considerado acima do peso"
                        imc >= 18.5f -> "que é considerado peso normal"
                        imc >= 18.4f -> "que é considerado abaixo do peso"

                        else -> "que é considerado obeso morbido"
                    }

                    mostrarMensagem(imc.toString()+resultado)
                } else if (binding.RgGenero.checkedRadioButtonId == R.id.RbFeminino) {

                    val resultado = when {
                        imc >= 31.1f -> "que é considerado acima do peso"
                        imc >= 24.99f -> "que é considerado um pouco acima do peso"
                        imc >= 18.5f -> "que é considerado peso normal"
                        imc >= 18.4f -> "que é considerado abaixo do peso"

                        else -> "que é considerado obeso morbido"
                    }

                    mostrarMensagem(imc.toString()+resultado)
                } else {
                    Toast.makeText(MainActivity@this, "escolha alguem genero", Toast.LENGTH_SHORT).show()
                }

            }


        }


    }

    private fun mostrarMensagem(mensagem: String) {
        alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(R.string.msg)
        alertDialog.setMessage(mensagem)
        alertDialog.setPositiveButton("ok") { dialog, _ ->
            dialog.dismiss()
        }
        alertDialog.show()
    }
}

