package br.com.gilbercs.appimc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Classe principal do app
    //declaração de variaveis/componentes da tela
    private EditText edtCampoPeso, edtCampoAltura;
    private Button btnCalcular, btnLimpar;
    private TextView txtSeuImc, txtInterpretacaoImc, txtInformacao;
    //Inicializar componentes
    public void inicializarComponentes(){
        edtCampoPeso = (EditText)findViewById(R.id.idCampoPeso);
        edtCampoAltura = (EditText)findViewById(R.id.idCampoAltura);
       btnCalcular = (Button)findViewById(R.id.idBtnCalcular);
       btnLimpar = (Button)findViewById(R.id.idBtnLimpar);
       txtSeuImc = (TextView)findViewById(R.id.idTxtSeuImc);
       txtInformacao = (TextView)findViewById(R.id.idTxtInformacao);
       txtInterpretacaoImc = (TextView)findViewById(R.id.idTxtInterpretacaoImc);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializar componontes
        inicializarComponentes();
        txtSeuImc.setVisibility(View.GONE);
        txtInformacao.setVisibility(View.GONE);
        txtInterpretacaoImc.setVisibility(View.GONE);
    }
//menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
//itens de menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.idDev:
                startActivity(new Intent(MainActivity.this, SobreActivity.class));
                break;
            case R.id.idSair:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
//recebendo dados de entrada
    public void calcularImc(View view){
        String strCampoPeso, strCampoAltura;
        strCampoPeso = edtCampoPeso.getText().toString();
        strCampoAltura = edtCampoAltura.getText().toString();
        //verificar campos e valida
        if (!strCampoPeso.isEmpty()){
            if (!strCampoAltura.isEmpty()){
                Double peso, altura, calculo;
                peso = Double.parseDouble(strCampoPeso);
                altura = Double.parseDouble(strCampoAltura);
                altura = altura * altura;
                calculo = peso/altura;
                if (calculo > 0) {
                    txtSeuImc.setVisibility(View.VISIBLE);
                    txtSeuImc.setText("Seu Imc: " + Math.round(calculo));
                    txtInformacao.setVisibility(View.VISIBLE);
                    txtInterpretacaoImc.setVisibility(View.VISIBLE);
                    interpretacaoImc(calculo);
                }
            }else{
                //aviso para preencher o campos vazio
                Toast.makeText(MainActivity.this,
                        "Preencha o campo Altura:!!",
                        Toast.LENGTH_LONG).show();
                //retornar p/ campo
                edtCampoAltura.requestFocus();
            }
        }else{
            //aviso para preencher o campos vazio
            Toast.makeText(MainActivity.this,
                    "Preencha o campo Peso:!!",
                    Toast.LENGTH_LONG).show();
            //retornar p/ campo
            edtCampoPeso.requestFocus();
        }
    }
    //limpar campos
    public void limparCampos(View view){
        txtSeuImc.setVisibility(View.GONE);
        txtInformacao.setVisibility(View.GONE);
        txtInterpretacaoImc.setVisibility(View.GONE);
        edtCampoPeso.setText("");
        edtCampoAltura.setText("");
        txtSeuImc.setText("");
        edtCampoPeso.requestFocus();
    }
    //intrepretação do imc
    public void interpretacaoImc(Double imc){
        if (imc < 18.5){
            txtInterpretacaoImc.setText("MENOR QUE 18,5 -> Baixo peso");
        }else{
            if (imc >= 18.5 && imc <24.9){
                txtInterpretacaoImc.setText("ENTRE 18,5 E 24,9 Peso Adequado");
            }else{
                if (imc ==25){
                    txtInterpretacaoImc.setText("Igual a 25 Risco de SobrePeso");
                }else{
                    if(imc>25 & imc <= 29.9){
                        txtInterpretacaoImc.setText("ENTRE 25,0 E 29,9 Pré-Obeso");
                    }else{
                        if (imc >= 30 && imc <= 34.9){
                            txtInterpretacaoImc.setText("ENTRE 30,0 E 34,9 Obesidade GRAU I");
                        }else{
                            if (imc >= 35 && imc <= 39.9){
                                txtInterpretacaoImc.setText("ENTRE 35,0 E 39,9 Obesidade GRAU II");
                            }else{
                                if (imc >40){
                                    txtInterpretacaoImc.setText("Igual ou Maior 40 Obesidade GRAU III");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}