    package br.com.etechoracio.etec_boaviagem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import br.com.etechoracio.etec_boaviagem.enums.TipoGastoEnum;

    public class GastoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto);

        spnTipoGasto = (Spinner) findViewById(R.id.spnTipoGasto);
        spnTipoGasto.setAdapter(getAdapterTipoGasto());
    }
    private Spinner spnTipoGasto;

    private ArrayAdapter getAdapterTipoGasto(){
        return new ArrayAdapter<TipoGastoEnum>(this,
                R.layout.support_simple_spinner_dropdown_item,
                TipoGastoEnum.values());
    }
}
