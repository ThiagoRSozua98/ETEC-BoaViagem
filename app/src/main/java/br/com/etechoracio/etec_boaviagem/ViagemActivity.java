package br.com.etechoracio.etec_boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;

public class ViagemActivity extends AppCompatActivity {

    private Button dataChegada;
    private Button dataSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viagem);
        dataChegada = findViewById(R.id.dataChegada);
        dataSaida =  findViewById(R.id.dataSaida);
    }

    private DatePickerDialog.OnDateSetListener dateListenerChegada = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            String data = String.valueOf(dia) + " /" + String.valueOf(mes + 1) + " /" + String.valueOf(ano);
            dataChegada.setText(data);

        }
    };
    private  DatePickerDialog.OnDateSetListener dateListenerSaida = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
           String data = String.valueOf(dia) + " /" + String.valueOf(mes+1) + " /" + String.valueOf(ano);
           dataSaida.setText(data);
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

}
