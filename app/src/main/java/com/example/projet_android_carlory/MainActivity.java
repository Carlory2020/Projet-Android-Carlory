package com.example.projet_android_carlory;

        import android.app.Activity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
public class MainActivity extends Activity {
    //On déclare toutes les variables dont on aura besoin
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnPlus;
    Button btnMoins;
    Button btnDiv;
    Button btnMult;
    Button btnC;
    Button btnEgal;
    Button btnPt;
    EditText screen;
    private double nb1;
    private boolean clicOperateur = false;
    private boolean update = false;
    private String operateur = "";
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//On récupère tous les éléments de notre interface graphique grâce aux ID
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnPt = (Button) findViewById(R.id.btnPt);
        btnPlus = (Button) findViewById(R.id.btnPs);
        btnMoins = (Button) findViewById(R.id.btnMs);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnC = (Button) findViewById(R.id.btnC);
        btnEgal = (Button) findViewById(R.id.btnEgal);
        screen = (EditText) findViewById(R.id.EditText01);
//On attribue un écouteur d'évènement à tous les boutons
        btnPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                plusClick();
            }
        });
        btnMoins.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                moinsClick();
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                divClick();
            }
        });
        btnMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mulClick();
            }
        });
        btnC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                resetClick();
            }
        });
        btnEgal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                egalClick();
            }
        });
        btnPt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick(".");
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                chiffreClick("9");
            }
        });
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur un bouton chiffre
    public void chiffreClick(String str) {
        if(update){
            update = false;
        }else{
            if(!screen.getText().equals("0"))
                str = screen.getText() + str;
        }
        screen.setText(str);
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton +
    public void plusClick(){
        if(clicOperateur){
            calcul();
            screen.setText(String.valueOf(nb1));
        }else{
            nb1 = Double.valueOf(screen.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "+";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton -
    public void moinsClick(){
        if(clicOperateur){
            calcul();
            screen.setText(String.valueOf(nb1));
        }else{
            nb1 = Double.valueOf(screen.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "-";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton *
    public void mulClick(){
        if(clicOperateur){
            calcul();
            screen.setText(String.valueOf(nb1));
        }else{
            nb1 = Double.valueOf(screen.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "*";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton /
    public void divClick(){
        if(clicOperateur){
            calcul();
            screen.setText(String.valueOf(nb1));
        }else{
            nb1 = Double.valueOf(screen.getText().toString()).doubleValue();
            clicOperateur = true;
        }
        operateur = "/";
        update = true;
    }
    //voici la méthode qui est exécutée lorsqu'on clique sur le bouton =
    public void egalClick(){
        calcul();
        update = true;
        clicOperateur = false;
    }
    //voici la méthode qui est exécutée lorsque l'on clique sur le bouton C
    public void resetClick(){
        clicOperateur = false;
        update = true;
        nb1 = 0;
        operateur = "";
        screen.setText("");
    }
    //Voici la méthode qui fait le calcul qui a été demandé par l'utilisateur
    private void calcul(){
        if(operateur.equals("+")){
            nb1 = nb1 +
                    Double.valueOf(screen.getText().toString()).doubleValue();
            screen.setText(String.valueOf(nb1));
        }
        if(operateur.equals("-")){
            nb1 = nb1 -
                    Double.valueOf(screen.getText().toString()).doubleValue();
            screen.setText(String.valueOf(nb1));
        }
        if(operateur.equals("*")){
            nb1 = nb1 *
                    Double.valueOf(screen.getText().toString()).doubleValue();
            screen.setText(String.valueOf(nb1));
        }
        if(operateur.equals("/")){
            try{
                nb1 = nb1 /
                        Double.valueOf(screen.getText().toString()).doubleValue();
                screen.setText(String.valueOf(nb1));
            }catch(ArithmeticException e){
                screen.setText("0");
            }
        }
    }
}