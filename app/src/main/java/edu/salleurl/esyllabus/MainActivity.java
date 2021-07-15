package edu.salleurl.esyllabus;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    int myBlue = Color.parseColor("#63AFED");
    int myRed = Color.parseColor("#DA0000");

    int numGreen;
    int numRed;
    int numBlue;

    private TextView tvRed;
    private TextView tvGreen;
    private TextView tvBlue;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor save;

    // Primer
    int countCalcul;
    int countElectro;
    int countProg;
    int countAlgebra;
    int countIO;
    int countBusiness;
    int countDiu;
    int countPic;

    // Segon
    int countMates;
    int countTrans;
    int countDpoo;
    int countBases;
    int countDiu2;
    int countLlenguatge;
    int countAnimacio3d;
    int countPic2;
    int countValue;
    int countGrafics3d;
    int countFoto;
    int countExpressio;

    // Tercer
    int countXarxes;
    int countPmm1;
    int countPic3;
    int countTv;
    int countPw1;
    int countPds;
    int countDramaturgia;
    int countSimulaciofisica;
    int countPw2;
    int countPdi;
    int countOm;

    // Quart
    int countPmm2;
    int countPractiques;
    int countPdap;
    int countIrv;
    int countTv_int;
    int countPm;
    int countTFG;
    int countTtecn;
    int countEntrepreneurship;

    //Optatives
    int countPrpr1;
    int countPrpr2;
    int countMarketing;
    int countMarketingSimu;
    int count_iOS;
    int count_other;

    // Primer
    private Button btnCalcul;
    private Button btnElectro;
    private Button btnProg;
    private Button btnAlgebra;
    private Button btnIO;
    private Button btnBusiness;
    private Button btnDiu;
    private Button btnPic;

    // Segon
    private Button btnMates;
    private Button btnTrans;
    private Button btnDpoo;
    private Button btnBases;
    private Button btnDiu2;
    private Button btnLlenguatge;
    private Button btnAnimacio3d;
    private Button btnPic2;
    private Button btnValue;
    private Button btnGrafics3d;
    private Button btnFoto;
    private Button btnExpressio;

    // Tercer
    private Button btnXarxes;
    private Button btnPmm1;
    private Button btnPic3;
    private Button btnTv;
    private Button btnPw1;
    private Button btnPds;
    private Button btnDramaturgia;
    private Button btnSimulaciofisica;
    private Button btnPw2;
    private Button btnPdi;
    private Button btnOm;

    // Quart
    private Button btnPmm2;
    private Button btnPractiques;
    private Button btnPdap;
    private Button btnIrv;
    private Button btnTv_int;
    private Button btnPm;
    private Button btnTFG;
    private Button btnTtecn;
    private Button btnEntrepreneurship;

    //Optatives
    private Button btnPrpr1;
    private Button btnPrpr2;
    private Button btnMarketing;
    private Button btnMarketingSimu;
    private Button btn_iOS;
    private Button btnOther;

    public int saveCount(int counter, String btnName) {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (counter == 3) {
            counter = 0;
        }
        counter++;

        editor.putInt(btnName, counter);
        editor.apply();

        return counter;
    }

    public void switchOnClicked(Button btn, int counter) {
        switch (counter) {
            case 1:
                btn.setBackgroundColor(myRed);
                if (numGreen != 0) {
                    numGreen -= Integer.parseInt(btn.getContentDescription().toString());
                }
                numRed += Integer.parseInt(btn.getContentDescription().toString());
                break;
            case 2:
                btn.setBackgroundColor(myBlue);
                if (numRed != 0) {
                    numRed -= Integer.parseInt(btn.getContentDescription().toString());
                }
                numBlue += Integer.parseInt(btn.getContentDescription().toString());
                break;
            case 3:
                btn.setBackgroundColor(Color.GREEN);
                if (numBlue != 0) {
                    numBlue -= Integer.parseInt(btn.getContentDescription().toString());
                }
                numGreen += Integer.parseInt(btn.getContentDescription().toString());

                break;
            default:
                /*
                numGreen = 0;
                numRed = 0;
                numBlue = 240;
                 */
                break;
        }

        System.out.println("numGreen: " + numGreen);
        System.out.println("numRed: " + numRed);
        System.out.println("numBlue: " + numBlue);

        save.putInt("red", numRed);
        save.putInt("green", numGreen);
        save.putInt("blue", numBlue);
        save.apply();

        tvRed.setText("Doing(" + numRed + ")");
        tvGreen.setText("Done(" + numGreen + ")");
        tvBlue.setText("Todo(" + numBlue + ")");
    }

    public int getCount(int counter, String btnName) {
        return getSharedPreferences(SHARED_PREFS, MODE_PRIVATE).getInt(btnName, counter);
    }

    public void paintNoClick(Button btn, int colored) {
        switch (colored) {
            case 1:
                btn.setBackgroundColor(myRed);
                break;
            case 2:
                btn.setBackgroundColor(myBlue);
                break;
            case 3:
                btn.setBackgroundColor(Color.GREEN);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        tvRed = (TextView) findViewById(R.id.tvred);
        tvGreen = (TextView) findViewById(R.id.tvgreen);
        tvBlue = (TextView) findViewById(R.id.tvblue);

        numRed = getCount(numRed, "red");
        numGreen = getCount(numGreen, "green");
        numBlue = getCount(numBlue, "blue");

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        save = sharedPreferences.edit();

        tvRed.setText("Doing(" + numRed + ")");
        tvGreen.setText("Done(" + numGreen + ")");
        tvBlue.setText("Todo(" + numBlue + ")");

        btnCalcul = (Button) findViewById(R.id.calcul);
        btnElectro = (Button) findViewById(R.id.electro);
        btnProg = (Button) findViewById(R.id.prog);
        btnAlgebra = (Button) findViewById(R.id.algebra);
        btnIO = (Button) findViewById(R.id.io);
        btnBusiness = (Button) findViewById(R.id.business);
        btnDiu = (Button) findViewById(R.id.diu1);
        btnPic = (Button) findViewById(R.id.pic1);

        countCalcul = getCount(countCalcul, "calcul");
        paintNoClick(btnCalcul, countCalcul);
        btnCalcul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countCalcul = saveCount(countCalcul, "calcul");
                switchOnClicked(btnCalcul, countCalcul);
            }
        });

        countElectro = getCount(countElectro, "electro");
        paintNoClick(btnElectro, countElectro);
        btnElectro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countElectro = saveCount(countElectro, "electro");
                switchOnClicked(btnElectro, countElectro);
            }
        });

        countProg = getCount(countProg, "prog");
        paintNoClick(btnProg, countProg);
        btnProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countProg = saveCount(countProg, "prog");
                switchOnClicked(btnProg, countProg);
            }
        });

        countAlgebra = getCount(countAlgebra, "algebra");
        paintNoClick(btnAlgebra, countAlgebra);
        btnAlgebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countAlgebra = saveCount(countAlgebra, "algebra");
                switchOnClicked(btnAlgebra, countAlgebra);
            }
        });

        countIO = getCount(countIO, "io");
        paintNoClick(btnIO, countIO);
        btnIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countIO = saveCount(countIO, "io");
                switchOnClicked(btnIO, countIO);
            }
        });

        countBusiness = getCount(countBusiness, "business");
        paintNoClick(btnBusiness, countBusiness);
        btnBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countBusiness = saveCount(countBusiness, "business");
                switchOnClicked(btnBusiness, countBusiness);
            }
        });

        countDiu = getCount(countDiu, "diu");
        paintNoClick(btnDiu, countDiu);
        btnDiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDiu = saveCount(countDiu, "diu");
                switchOnClicked(btnDiu, countDiu);
            }
        });

        countPic = getCount(countPic, "pic");
        paintNoClick(btnPic, countPic);
        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPic = saveCount(countPic, "pic");
                switchOnClicked(btnPic, countPic);
            }
        });

        btnMates = (Button) findViewById(R.id.mates);
        btnTrans = (Button) findViewById(R.id.trans);
        btnDpoo = (Button) findViewById(R.id.dpoo);
        btnBases = (Button) findViewById(R.id.bases);
        btnDiu2 = (Button) findViewById(R.id.diu2);
        btnLlenguatge = (Button) findViewById(R.id.llenguatge);
        btnAnimacio3d = (Button) findViewById(R.id.animacio3d);
        btnPic2 = (Button) findViewById(R.id.pic2);
        btnValue = (Button) findViewById(R.id.value);
        btnGrafics3d = (Button) findViewById(R.id.grafics3d);
        btnFoto = (Button) findViewById(R.id.foto);
        btnExpressio = (Button) findViewById(R.id.expressio);

        countMates = getCount(countMates, "mates");
        paintNoClick(btnMates, countMates);
        btnMates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMates = saveCount(countMates, "mates");
                switchOnClicked(btnMates, countMates);
            }
        });

        countTrans = getCount(countTrans, "trans");
        paintNoClick(btnTrans, countTrans);
        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTrans = saveCount(countTrans, "trans");
                switchOnClicked(btnTrans, countTrans);
            }
        });

        countDpoo = getCount(countDpoo, "dpoo");
        paintNoClick(btnDpoo, countDpoo);
        btnDpoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDpoo = saveCount(countDpoo, "dpoo");
                switchOnClicked(btnDpoo, countDpoo);
            }
        });

        countBases = getCount(countBases, "bases");
        paintNoClick(btnBases, countBases);
        btnBases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countBases = saveCount(countBases, "bases");
                switchOnClicked(btnBases, countBases);
            }
        });

        countDiu2 = getCount(countDiu2, "diu2");
        paintNoClick(btnDiu2, countDiu2);
        btnDiu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDiu2 = saveCount(countDiu2, "diu2");
                switchOnClicked(btnDiu2, countDiu2);
            }
        });

        countLlenguatge = getCount(countLlenguatge, "llenguatge");
        paintNoClick(btnLlenguatge, countLlenguatge);
        btnLlenguatge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countLlenguatge = saveCount(countLlenguatge, "llenguatge");
                switchOnClicked(btnLlenguatge, countLlenguatge);
            }
        });

        countAnimacio3d = getCount(countAnimacio3d, "animacio3d");
        paintNoClick(btnAnimacio3d, countAnimacio3d);
        btnAnimacio3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countAnimacio3d = saveCount(countAnimacio3d, "animacio3d");
                switchOnClicked(btnAnimacio3d, countAnimacio3d);
            }
        });

        countPic2 = getCount(countPic2, "pic2");
        paintNoClick(btnPic2, countPic2);
        btnPic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPic2 = saveCount(countPic2, "pic2");
                switchOnClicked(btnPic2, countPic2);
            }
        });

        countValue = getCount(countValue, "value");
        paintNoClick(btnValue, countValue);
        btnValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countValue = saveCount(countValue, "value");
                switchOnClicked(btnValue, countValue);
            }
        });

        countGrafics3d = getCount(countGrafics3d, "grafics3d");
        paintNoClick(btnGrafics3d, countGrafics3d);
        btnGrafics3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countGrafics3d = saveCount(countGrafics3d, "grafics3d");
                switchOnClicked(btnGrafics3d, countGrafics3d);
            }
        });

        countFoto = getCount(countFoto, "foto");
        paintNoClick(btnFoto, countFoto);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countFoto = saveCount(countFoto, "foto");
                switchOnClicked(btnFoto, countFoto);
            }
        });

        countExpressio = getCount(countExpressio, "expressio");
        paintNoClick(btnExpressio, countExpressio);
        btnExpressio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countExpressio = saveCount(countExpressio, "expressio");
                switchOnClicked(btnExpressio, countExpressio);
            }
        });


        btnXarxes = (Button) findViewById(R.id.xarxes);
        btnPmm1 = (Button) findViewById(R.id.pmm1);
        btnPic3 = (Button) findViewById(R.id.pic3);
        btnTv = (Button) findViewById(R.id.tv);
        btnPw1 = (Button) findViewById(R.id.pw1);
        btnPds = (Button) findViewById(R.id.pds);
        btnDramaturgia = (Button) findViewById(R.id.dramaturgia);
        btnSimulaciofisica = (Button) findViewById(R.id.simulaciofisica);
        btnPw2 = (Button) findViewById(R.id.pw2);
        btnPdi = (Button) findViewById(R.id.pdi);
        btnOm = (Button) findViewById(R.id.om);

        countXarxes = getCount(countXarxes, "xarxes");
        paintNoClick(btnXarxes, countXarxes);
        btnXarxes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countXarxes = saveCount(countXarxes, "xarxes");
                switchOnClicked(btnXarxes, countXarxes);
            }
        });

        countPmm1 = getCount(countPmm1, "pmm1");
        paintNoClick(btnPmm1, countPmm1);
        btnPmm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPmm1 = saveCount(countPmm1, "pmm1");
                switchOnClicked(btnPmm1, countPmm1);
            }
        });

        countPic3 = getCount(countPic3, "pic3");
        paintNoClick(btnPic3, countPic3);
        btnPic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPic3 = saveCount(countPic3, "pic3");
                switchOnClicked(btnPic3, countPic3);
            }
        });

        countTv = getCount(countTv, "tv");
        paintNoClick(btnTv, countTv);
        btnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTv = saveCount(countTv, "tv");
                switchOnClicked(btnTv, countTv);
            }
        });

        countPw1 = getCount(countPw1, "pw1");
        paintNoClick(btnPw1, countPw1);
        btnPw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPw1 = saveCount(countPw1, "pw1");
                switchOnClicked(btnPw1, countPw1);
            }
        });

        countPds = getCount(countPds, "pds");
        paintNoClick(btnPds, countPds);
        btnPds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPds = saveCount(countPds, "pds");
                switchOnClicked(btnPds, countPds);
            }
        });

        countDramaturgia = getCount(countDramaturgia, "dramaturgia");
        paintNoClick(btnDramaturgia, countDramaturgia);
        btnDramaturgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDramaturgia = saveCount(countDramaturgia, "dramaturgia");
                switchOnClicked(btnDramaturgia, countDramaturgia);
            }
        });

        countSimulaciofisica = getCount(countSimulaciofisica, "simulaciofisica");
        paintNoClick(btnSimulaciofisica, countSimulaciofisica);
        btnSimulaciofisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countSimulaciofisica = saveCount(countSimulaciofisica, "simulaciofisica");
                switchOnClicked(btnSimulaciofisica, countSimulaciofisica);
            }
        });

        countPw2 = getCount(countPw2, "pw2");
        paintNoClick(btnPw2, countPw2);
        btnPw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPw2 = saveCount(countPw2, "pw2");
                switchOnClicked(btnPw2, countPw2);
            }
        });

        countPdi = getCount(countPdi, "pdi");
        paintNoClick(btnPdi, countPdi);
        btnPdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPdi = saveCount(countPdi, "pdi");
                switchOnClicked(btnPdi, countPdi);
            }
        });

        countOm = getCount(countOm, "om");
        paintNoClick(btnOm, countOm);
        btnOm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countOm = saveCount(countOm, "om");
                switchOnClicked(btnOm, countOm);
            }
        });


        btnPmm2 = (Button) findViewById(R.id.pmm2);
        btnPractiques = (Button) findViewById(R.id.practiques);
        btnPdap = (Button) findViewById(R.id.pdap);
        btnIrv = (Button) findViewById(R.id.irv);
        btnTv_int = (Button) findViewById(R.id.tv_int);
        btnPm = (Button) findViewById(R.id.pm);
        btnTFG = (Button) findViewById(R.id.tfg);
        btnTtecn = (Button) findViewById(R.id.ttecn);
        btnEntrepreneurship = (Button) findViewById(R.id.entrepreneurship);

        countPmm2 = getCount(countPmm2, "pmm2");
        paintNoClick(btnPmm2, countPmm2);
        btnPmm2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPmm2 = saveCount(countPmm2, "pmm2");
                switchOnClicked(btnPmm2, countPmm2);
            }
        });

        countPractiques = getCount(countPractiques, "practiques");
        paintNoClick(btnPractiques, countPractiques);
        btnPractiques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPractiques = saveCount(countPractiques, "practiques");
                switchOnClicked(btnPractiques, countPractiques);
            }
        });

        countPdap = getCount(countPdap, "pdap");
        paintNoClick(btnPdap, countPdap);
        btnPdap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPdap = saveCount(countPdap, "pdap");
                switchOnClicked(btnPdap, countPdap);
            }
        });

        countIrv = getCount(countIrv, "irv");
        paintNoClick(btnIrv, countIrv);
        btnIrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countIrv = saveCount(countIrv, "irv");
                switchOnClicked(btnIrv, countIrv);
            }
        });

        countTv_int = getCount(countTv_int, "tv_int");
        paintNoClick(btnTv_int, countTv_int);
        btnTv_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTv_int = saveCount(countTv_int, "tv_int");
                switchOnClicked(btnTv_int, countTv_int);
            }
        });

        countPm = getCount(countPm, "pm");
        paintNoClick(btnPm, countPm);
        btnPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPm = saveCount(countPm, "pm");
                switchOnClicked(btnPm, countPm);
            }
        });

        countTFG = getCount(countTFG, "tfg");
        paintNoClick(btnTFG, countTFG);
        btnTFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTFG = saveCount(countTFG, "tfg");
                switchOnClicked(btnTFG, countTFG);
            }
        });

        countTtecn = getCount(countTtecn, "ttecn");
        paintNoClick(btnTtecn, countTtecn);
        btnTtecn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countTtecn = saveCount(countTtecn, "ttecn");
                switchOnClicked(btnTtecn, countTtecn);
            }
        });

        countEntrepreneurship = getCount(countEntrepreneurship, "entrepreneurship");
        paintNoClick(btnEntrepreneurship, countEntrepreneurship);
        btnEntrepreneurship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countEntrepreneurship = saveCount(countEntrepreneurship, "entrepreneurship");
                switchOnClicked(btnEntrepreneurship, countEntrepreneurship);
            }
        });


        btnPrpr1 = (Button) findViewById(R.id.prpr1);
        btnPrpr2 = (Button) findViewById(R.id.prpr2);
        btnMarketing = (Button) findViewById(R.id.marketing);
        btnMarketingSimu = (Button) findViewById(R.id.marketingsimulations);
        btn_iOS = (Button) findViewById(R.id.ios);
        btnOther = (Button) findViewById(R.id.other);

        countPrpr1 = getCount(countPrpr1, "prpr1");
        paintNoClick(btnPrpr1, countPrpr1);
        btnPrpr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPrpr1 = saveCount(countPrpr1, "prpr1");
                switchOnClicked(btnPrpr1, countPrpr1);
            }
        });

        countPrpr2 = getCount(countPrpr2, "prpr2");
        paintNoClick(btnPrpr2, countPrpr2);
        btnPrpr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countPrpr2 = saveCount(countPrpr2, "prpr2");
                switchOnClicked(btnPrpr2, countPrpr2);
            }
        });

        countMarketing = getCount(countMarketing, "marketing");
        paintNoClick(btnMarketing, countMarketing);
        btnMarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMarketing = saveCount(countMarketing, "marketing");
                switchOnClicked(btnMarketing, countMarketing);
            }
        });

        countMarketingSimu = getCount(countMarketingSimu, "marketing");
        paintNoClick(btnMarketingSimu, countMarketingSimu);
        btnMarketingSimu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countMarketingSimu = saveCount(countMarketingSimu, "marketing");
                switchOnClicked(btnMarketingSimu, countMarketingSimu);
            }
        });

        count_iOS = getCount(count_iOS, "ios");
        paintNoClick(btn_iOS, count_iOS);
        btn_iOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_iOS = saveCount(count_iOS, "ios");
                switchOnClicked(btn_iOS, count_iOS);
            }
        });

        count_other = getCount(count_other, "other");
        paintNoClick(btnOther, count_other);
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count_other = saveCount(count_other, "other");
                switchOnClicked(btnOther, count_other);
            }
        });

    }
}


