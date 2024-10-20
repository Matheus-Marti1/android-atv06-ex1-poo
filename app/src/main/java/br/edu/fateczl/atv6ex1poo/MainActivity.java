/*
@author:<Matheus Augusto Marti>
 */

package br.edu.fateczl.atv6ex1poo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.edu.fateczl.atv6ex1poo.model.Professor;
import br.edu.fateczl.atv6ex1poo.model.ProfessorHorista;
import br.edu.fateczl.atv6ex1poo.model.ProfessorTitular;

public class MainActivity extends AppCompatActivity {

    private RadioButton rbTitular;
    private RadioButton rbHorista;
    private EditText etSalario;
    private EditText etHoras;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rbTitular = findViewById(R.id.rbTitular);
        rbTitular.setChecked(true);
        rbHorista = findViewById(R.id.rbHorista);
        etSalario = findViewById(R.id.etSalario);
        etHoras = findViewById(R.id.etHoras);
        tvRes = findViewById(R.id.tvRes);
        Button btnCalc = findViewById(R.id.btnCalc);
        btnCalc.setOnClickListener(op -> calc());
    }

    private void calc() {
        double valorSalario = Double.parseDouble(etSalario.getText().toString());
        int tempo = Integer.parseInt(etHoras.getText().toString());
        if (rbTitular.isChecked()){
            ProfessorTitular profTit = new ProfessorTitular();
            profTit.setAnosInstituicao(tempo);
            profTit.setSalario(valorSalario);
            double salario = profTit.calcSalario();
            BigDecimal sal = BigDecimal.valueOf(salario).setScale(2, RoundingMode.HALF_UP);
            tvRes.setText(getString(R.string.res) + sal);
        }
        if (rbHorista.isChecked()){
            ProfessorHorista profHor = new ProfessorHorista();
            profHor.setHorasAula(tempo);
            profHor.setValorHoraAula(valorSalario);
            double salario = profHor.calcSalario();
            BigDecimal sal = BigDecimal.valueOf(salario).setScale(2, RoundingMode.HALF_UP);
            tvRes.setText(getString(R.string.res) + sal);
        }
    }
}