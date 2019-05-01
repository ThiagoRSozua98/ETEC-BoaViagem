package br.com.etechoracio.etec_boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Calendar;

import br.com.etechoracio.etec_boaviagem.model.Viagem;
import br.com.etechoracio.etec_boaviagem.utils.DateTimeUtils;

public class ViagemActivity extends AppCompatActivity {

    private Button dataChegada;
    private Button dataSaida;

    private EditText editDestino;
    private EditText editQuantidadePessoas;
    private EditText editOrcamento;
    private RadioGroup radioTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem);
        dataChegada = findViewById(R.id.dataChegada);
        dataSaida =  findViewById(R.id.dataSaida);

        editDestino = findViewById(R.id.editDestino);
        editQuantidadePessoas = findViewById(R.id.editQuantidadePessoas);
        editOrcamento = findViewById(R.id.editOrcamento);
        radioTipo = findViewById(R.id.radioTipo);
    }

    private DatePickerDialog.OnDateSetListener dateListenerChegada = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            //String data = String.valueOf(dia) + " /" + String.valueOf(mes + 1) + " /" + String.valueOf(ano);
            dataChegada.setText(DateTimeUtils.formatDate(dia, mes + 1, ano));

        }
    };
    private  DatePickerDialog.OnDateSetListener dateListenerSaida = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
           //String data = String.valueOf(dia) + " /" + String.valueOf(mes+1) + " /" + String.valueOf(ano);
           dataSaida.setText(DateTimeUtils.formatDate(dia, mes + 1, ano));
        }
    };
    
    protected Dialog onCreateDialog(int id){
        Calendar cal = Calendar.getInstance();
        int ano = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        switch (id){
            case R.id.dataChegada:
                return new DatePickerDialog(this, dateListenerChegada, ano, mes, dia);

            case R.id.dataSaida:
                return new DatePickerDialog(this, dateListenerSaida, ano, mes, dia);
        }
        return null;
    }

    public void onSelecionarData(View view) {

        showDialog(view.getId());

    }

    public void onSalvar(View view){

        Viagem viagem = new Viagem();
        viagem.setDestino(editDestino.getText().toString());
        viagem.setDataChegada(DateTimeUtils.toDate(dataChegada.getText().toString()));
        viagem.setDataSaida(DateTimeUtils.toDate(dataSaida.getText().toString()));
        viagem.setOrcamento(Double.valueOf(editOrcamento.getText().toString()));
        viagem.setQuantidadePessoas(Integer.valueOf(editQuantidadePessoas.getText().toString()));

    }



}
