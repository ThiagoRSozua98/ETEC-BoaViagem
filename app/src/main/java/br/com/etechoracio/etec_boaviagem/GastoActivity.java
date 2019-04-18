    package br.com.etechoracio.etec_boaviagem;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import java.util.Calendar;

import br.com.etechoracio.etec_boaviagem.enums.TipoGastoEnum;

    public class GastoActivity extends AppCompatActivity {

        private Button dataGasto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto);

        dataGasto = findViewById(R.id.dataGasto);
        spnTipoGasto = (Spinner) findViewById(R.id.spnTipoGasto);
        spnTipoGasto.setAdapter(getAdapterTipoGasto());
    }

    private Spinner spnTipoGasto;

    private ArrayAdapter getAdapterTipoGasto(){
        return new ArrayAdapter<TipoGastoEnum>(this,
                R.layout.support_simple_spinner_dropdown_item,
                TipoGastoEnum.values());
    }

    private DatePickerDialog.OnDateSetListener dateListenerGasto = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            String data = String.valueOf(dia) + " /" + String.valueOf(mes + 1) + " /" + String.valueOf(ano);
            dataGasto.setText(data);

        }
    };

    protected Dialog onCreateDialog(int id){
        Calendar calen = Calendar.getInstance();
        int ano = calen.get(Calendar.YEAR);
        int mes = calen.get(Calendar.MONTH);
        int dia = calen.get(Calendar.DAY_OF_MONTH);

        switch (id){
            case R.id.dataGasto:
                return new DatePickerDialog(this,dateListenerGasto, ano, mes, dia);
        }
        return null;
    }

        public void onSelecionarData(View view){

            showDialog(view.getId());

        }
    }
A