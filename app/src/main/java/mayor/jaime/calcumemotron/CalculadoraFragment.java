package mayor.jaime.calcumemotron;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class CalculadoraFragment extends Fragment {

    public static final String PREFS_NAME = "MyPrefsFile";
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bsum, bres, bmul, bdiv, bdot, beq;
    Button bm, bmc, bans, bclean;
    TextView txv;
    String numact = "", numant = "", nummem = "";
    Double res = 0.0;
    Boolean calc= false, reset = true, dot = false;
    Integer op = 0;
    View.OnClickListener lis = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.buttonsum:
                    if (calc) {
                        numact = txv.getText().toString();
                        res = calcula(Double.parseDouble(numant), Double.parseDouble(numact), op);
                        txv.setText(new Double(res).toString());
                        op = 1;
                        numant = (new Double(res).toString());
                        reset = true;
                    } else {
                        numant = txv.getText().toString();
                        op = 1;
                        calc = true;
                        reset = true;
                    }
                    break;
                case R.id.buttonres:
                    if (calc) {
                        numact = txv.getText().toString();
                        res = calcula(Double.parseDouble(numant), Double.parseDouble(numact), op);
                        txv.setText(new Double(res).toString());
                        op = 2;
                        numant = (new Double(res).toString());
                        reset = true;
                    } else {
                        numant = txv.getText().toString();
                        op = 2;
                        calc = true;
                        reset = true;
                    }
                    break;
                case R.id.buttonmul:
                    if (calc) {
                        numact = txv.getText().toString();
                        res = calcula(Double.parseDouble(numant), Double.parseDouble(numact), op);
                        txv.setText(new Double(res).toString());
                        op = 3;
                        numant = (new Double(res).toString());
                        reset = true;
                    } else {
                        numant = txv.getText().toString();
                        op = 3;
                        calc = true;
                        reset = true;
                    }
                    break;
                case R.id.buttondiv:
                    if (calc) {
                        numact = txv.getText().toString();
                        res = calcula(Double.parseDouble(numant), Double.parseDouble(numact), op);
                        txv.setText(new Double(res).toString());
                        op = 4;
                        numant = (new Double(res).toString());
                        reset = true;
                    } else {
                        numant = txv.getText().toString();
                        op = 4;
                        calc = true;
                        reset = true;
                    }
                    break;
                case R.id.buttoneq:
                    if (calc) {
                        numact = txv.getText().toString();
                        res = calcula(Double.parseDouble(numant), Double.parseDouble(numact), op);
                        txv.setText(new Double(res).toString());
                        numant = (new Double(res).toString());
                        reset = true;
                        calc = false;
                        dot = false;
                    }
                    break;
                case R.id.buttonclean:
                    txv.setText("0");
                    numact = "";
                    numant = "";
                    calc = false;
                    reset = true;
                    op = 0;
                    dot = false;
                    break;
                case R.id.buttonmem:
                    if(nummem.equals("") && !nummem.equals("0")) {
                        nummem = txv.getText().toString();
                    }
                    else {
                        txv.setText(nummem);
                    }
                    break;
                case R.id.buttonmclean:
                    nummem ="";
                    break;
                case R.id.buttonans:
                    txv.setText(new Double(res).toString());
                    break;
            }
        }
    };
    SharedPreferences prefs;
    View.OnClickListener lisnum = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button0:
                    if(reset)  {
                        txv.setText("");
                    }
                    txv.setText(txv.getText()+"0");
                    break;
                case R.id.button1:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "1");
                    break;
                case R.id.button2:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "2");
                    break;
                case R.id.button3:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "3");
                    break;
                case R.id.button4:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "4");
                    break;
                case R.id.button5:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "5");
                    break;
                case R.id.button6:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "6");
                    break;
                case R.id.button7:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "7");
                    break;
                case R.id.button8:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "8");
                    break;
                case R.id.button9:
                    if(reset)  {
                        txv.setText("");
                        dot = false;
                        reset = false;
                    }
                    txv.setText(txv.getText()+ "9");
                    break;
                case R.id.buttondot:
                    if(!dot) {
                        if(reset) {
                            txv.setText("0.");
                            reset = false;
                        }
                        else {
                            txv.setText(txv.getText() + ".");
                        }
                        dot = true;
                    }
                    break;

            }

        }
    };
    private ActionBarDrawerToggle mDrawerToggle;

    Double calcula(Double num1, Double num2, Integer op) {
        Double res = 0.0;
        if (op == 1) res = num1+num2;
        else if (op ==2) res = num1-num2;
        else if (op == 3) res = num1*num2;
        else if (op == 4) res = num1/num2;
        return res;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.calculadora, container, false);
        prefs = this.getActivity().getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        txv =(TextView) rootView.findViewById(R.id.textViewResul);
        b0 = (Button) rootView.findViewById(R.id.button0);
        b0.setOnClickListener(lisnum);
        b1 = (Button) rootView.findViewById(R.id.button1);
        b1.setOnClickListener(lisnum);
        b2 = (Button) rootView.findViewById(R.id.button2);
        b2.setOnClickListener(lisnum);
        b3 = (Button) rootView.findViewById(R.id.button3);
        b3.setOnClickListener(lisnum);
        b4 = (Button) rootView.findViewById(R.id.button4);
        b4.setOnClickListener(lisnum);
        b5 = (Button) rootView.findViewById(R.id.button5);
        b5.setOnClickListener(lisnum);
        b6 = (Button) rootView.findViewById(R.id.button6);
        b6.setOnClickListener(lisnum);
        b7 = (Button) rootView.findViewById(R.id.button7);
        b7.setOnClickListener(lisnum);
        b8 = (Button) rootView.findViewById(R.id.button8);
        b8.setOnClickListener(lisnum);
        b9 = (Button) rootView.findViewById(R.id.button9);
        b9.setOnClickListener(lisnum);
        bsum = (Button) rootView.findViewById(R.id.buttonsum);
        bsum.setOnClickListener(lis);
        bres = (Button) rootView.findViewById(R.id.buttonres);
        bres.setOnClickListener(lis);
        bmul = (Button) rootView.findViewById(R.id.buttonmul);
        bmul.setOnClickListener(lis);
        bdiv = (Button) rootView.findViewById(R.id.buttondiv);
        bdiv.setOnClickListener(lis);
        bans = (Button) rootView.findViewById(R.id.buttonans);
        bans.setOnClickListener(lis);
        bdot = (Button) rootView.findViewById(R.id.buttondot);
        bdot.setOnClickListener(lisnum);
        beq = (Button) rootView.findViewById(R.id.buttoneq);
        beq.setOnClickListener(lis);
        bm = (Button) rootView.findViewById(R.id.buttonmem);
        bm.setOnClickListener(lis);
        bmc = (Button) rootView.findViewById(R.id.buttonmclean);
        bmc.setOnClickListener(lis);
        bclean = (Button) rootView.findViewById(R.id.buttonclean);
        bclean.setOnClickListener(lis);
        getActivity().setTitle("Calculadora");
        setHasOptionsMenu(true);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        calc = prefs.getBoolean("calc",false);
        numant = prefs.getString("numant","");
        numact = prefs.getString("numact","");
        op= prefs.getInt("op",0);
        reset = prefs.getBoolean("reset",true);
        res= Double.parseDouble(prefs.getString("result","0.0"));
        dot = prefs.getBoolean("dot",false);
        Log.i("dot",dot.toString());
        txv.setText(prefs.getString("txv","0.0"));
    }

    @Override
    public void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("calc",calc);
        editor.putInt("op",op);
        editor.putString("numant",numant);
        editor.putString("numact",numact);
        editor.putBoolean("reset",reset);
        editor.putString("result",res.toString());
        editor.putBoolean("dot",dot);
        Log.i("dotStop",dot.toString());
        editor.putString("txv",txv.getText().toString());
        editor.apply();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_calc, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.llamar:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + txv.getText()));
                startActivity(intent);
                break;
            case R.id.internet:
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.es"));
                startActivity(i);
                break;
           /* case R.id.toast:
                if (!toast) {
                    activate_toast();
                }
                break;
            case R.id.not:
                if (toast) {
                    activate_notif();
                }
                break;*/
        }
        return super.onOptionsItemSelected(item);
    }

}
