package edu.salleurl.esyllabus;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    //int myBlue = Color.parseColor("#63AFED");
    //int myBlue = Color.parseColor("#3344ff");
    /*int myBlue = Color.parseColor("#0780fe");*/
    /*int myBlue = Color.parseColor("#C7C7C3");*/
    int myBlue = Color.parseColor("#4D93E8");
    /*int myBlue = Color.WHITE;*/


    //int myRed = Color.parseColor("#DA0000");
    /*int myRed = Color.parseColor("#b30000");*/
    int myRed = Color.YELLOW;

    //int myGreen = Color.GREEN;
    int myGreen = Color.parseColor("#00e600");


    int numGreen;
    int numRed;
    int numBlue;

    private TextView tvRed;
    private TextView tvGreen;
    private TextView tvBlue;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor save;

    private Button btnReset;

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
    int count_paed;
    int count_intensiProg;

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
    private Button btnPaed;
    private Button btnIntensiProg;

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

        if (counter == 0) {
            btn.setBackgroundColor(myRed);
            numRed += Integer.parseInt(btn.getContentDescription().toString());
            counter++;
        } else {
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
                    btn.setBackgroundColor(myGreen);
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
        }

        System.out.println("numGreen: " + numGreen);
        System.out.println("numRed: " + numRed);
        System.out.println("numBlue: " + numBlue);

        save.putInt("red", numRed);
        save.putInt("green", numGreen);
        save.putInt("blue", numBlue);
        save.apply();

        tvRed.setText("" + numRed + "");
        tvBlue.setText("" + numBlue + "");
        tvGreen.setText("" + numGreen + "");
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
                btn.setBackgroundColor(myGreen);
                break;
            default:
                btn.setBackgroundColor(Color.WHITE);
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

        tvRed.setTextColor(myRed);
        tvGreen.setTextColor(myGreen);
        tvBlue.setTextColor(myBlue);

        numRed = getCount(numRed, "red");
        numGreen = getCount(numGreen, "green");
        numBlue = getCount(numBlue, "blue");

        sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        save = sharedPreferences.edit();

        tvRed.setText("" + numRed + "");
        tvGreen.setText("" + numGreen + "");
        tvBlue.setText("" + numBlue + "");

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
                if (countCalcul != 0) {
                    countCalcul = saveCount(countCalcul, "calcul");
                    switchOnClicked(btnCalcul, countCalcul);
                } else {
                    switchOnClicked(btnCalcul, countCalcul);
                    countCalcul = saveCount(countCalcul, "calcul");
                }
            }
        });

        countElectro = getCount(countElectro, "electro");
        paintNoClick(btnElectro, countElectro);
        btnElectro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countElectro != 0) {
                    countElectro = saveCount(countElectro, "electro");
                    switchOnClicked(btnElectro, countElectro);
                } else {
                    switchOnClicked(btnElectro, countElectro);
                    countElectro = saveCount(countElectro, "electro");
                }
            }
        });

        countProg = getCount(countProg, "prog");
        paintNoClick(btnProg, countProg);
        btnProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countProg != 0) {
                    countProg = saveCount(countProg, "prog");
                    switchOnClicked(btnProg, countProg);
                } else {
                    switchOnClicked(btnProg, countProg);
                    countProg = saveCount(countProg, "prog");
                }
            }
        });

        countAlgebra = getCount(countAlgebra, "algebra");
        paintNoClick(btnAlgebra, countAlgebra);
        btnAlgebra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countAlgebra != 0) {
                    countAlgebra = saveCount(countAlgebra, "algebra");
                    switchOnClicked(btnAlgebra, countAlgebra);
                } else {
                    switchOnClicked(btnAlgebra, countAlgebra);
                    countAlgebra = saveCount(countAlgebra, "algebra");
                }
            }
        });

        countIO = getCount(countIO, "io");
        paintNoClick(btnIO, countIO);
        btnIO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countIO != 0) {
                    countIO = saveCount(countIO, "io");
                    switchOnClicked(btnIO, countIO);
                } else {
                    switchOnClicked(btnIO, countIO);
                    countIO = saveCount(countIO, "io");
                }
            }
        });

        countBusiness = getCount(countBusiness, "business");
        paintNoClick(btnBusiness, countBusiness);
        btnBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countBusiness != 0) {
                    countBusiness = saveCount(countBusiness, "business");
                    switchOnClicked(btnBusiness, countBusiness);
                } else {
                    switchOnClicked(btnBusiness, countBusiness);
                    countBusiness = saveCount(countBusiness, "business");
                }
            }
        });

        countDiu = getCount(countDiu, "diu");
        paintNoClick(btnDiu, countDiu);
        btnDiu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDiu != 0) {
                    countDiu = saveCount(countDiu, "diu");
                    switchOnClicked(btnDiu, countDiu);
                } else {
                    switchOnClicked(btnDiu, countDiu);
                    countDiu = saveCount(countDiu, "diu");
                }
            }
        });

        countPic = getCount(countPic, "pic");
        paintNoClick(btnPic, countPic);
        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPic != 0) {
                    countPic = saveCount(countPic, "pic");
                    switchOnClicked(btnPic, countPic);
                } else {
                    switchOnClicked(btnPic, countPic);
                    countPic = saveCount(countPic, "pic");
                }
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
                if (countMates != 0) {
                    countMates = saveCount(countMates, "mates");
                    switchOnClicked(btnMates, countMates);
                } else {
                    switchOnClicked(btnMates, countMates);
                    countMates = saveCount(countMates, "mates");
                }
            }
        });

        countTrans = getCount(countTrans, "trans");
        paintNoClick(btnTrans, countTrans);
        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countTrans != 0) {
                    countTrans = saveCount(countTrans, "trans");
                    switchOnClicked(btnTrans, countTrans);
                } else {
                    switchOnClicked(btnTrans, countTrans);
                    countTrans = saveCount(countTrans, "trans");
                }
            }
        });

        countDpoo = getCount(countDpoo, "dpoo");
        paintNoClick(btnDpoo, countDpoo);
        btnDpoo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDpoo != 0) {
                    countDpoo = saveCount(countDpoo, "dpoo");
                    switchOnClicked(btnDpoo, countDpoo);
                } else {
                    switchOnClicked(btnDpoo, countDpoo);
                    countDpoo = saveCount(countDpoo, "dpoo");
                }
            }
        });

        countBases = getCount(countBases, "bases");
        paintNoClick(btnBases, countBases);
        btnBases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countBases != 0) {
                    countBases = saveCount(countBases, "bases");
                    switchOnClicked(btnBases, countBases);
                } else {
                    switchOnClicked(btnBases, countBases);
                    countBases = saveCount(countBases, "bases");
                }
            }
        });

        countDiu2 = getCount(countDiu2, "diu2");
        paintNoClick(btnDiu2, countDiu2);
        btnDiu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDiu2 != 0) {
                    countDiu2 = saveCount(countDiu2, "diu2");
                    switchOnClicked(btnDiu2, countDiu2);
                } else {
                    switchOnClicked(btnDiu2, countDiu2);
                    countDiu2 = saveCount(countDiu2, "diu2");
                }
            }
        });

        countLlenguatge = getCount(countLlenguatge, "llenguatge");
        paintNoClick(btnLlenguatge, countLlenguatge);
        btnLlenguatge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countLlenguatge != 0) {
                    countLlenguatge = saveCount(countLlenguatge, "llenguatge");
                    switchOnClicked(btnLlenguatge, countLlenguatge);
                } else {
                    switchOnClicked(btnLlenguatge, countLlenguatge);
                    countLlenguatge = saveCount(countLlenguatge, "llenguatge");
                }
            }
        });

        countAnimacio3d = getCount(countAnimacio3d, "animacio3d");
        paintNoClick(btnAnimacio3d, countAnimacio3d);
        btnAnimacio3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countAnimacio3d != 0) {
                    countAnimacio3d = saveCount(countAnimacio3d, "animacio3d");
                    switchOnClicked(btnAnimacio3d, countAnimacio3d);
                } else {
                    switchOnClicked(btnAnimacio3d, countAnimacio3d);
                    countAnimacio3d = saveCount(countAnimacio3d, "animacio3d");
                }
            }
        });

        countPic2 = getCount(countPic2, "pic2");
        paintNoClick(btnPic2, countPic2);
        btnPic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPic2 != 0) {
                    countPic2 = saveCount(countPic2, "pic2");
                    switchOnClicked(btnPic2, countPic2);
                } else {
                    switchOnClicked(btnPic2, countPic2);
                    countPic2 = saveCount(countPic2, "pic2");
                }
            }
        });

        countValue = getCount(countValue, "value");
        paintNoClick(btnValue, countValue);
        btnValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countValue != 0) {
                    countValue = saveCount(countValue, "value");
                    switchOnClicked(btnValue, countValue);
                } else {
                    switchOnClicked(btnValue, countValue);
                    countValue = saveCount(countValue, "value");
                }
            }
        });

        countGrafics3d = getCount(countGrafics3d, "grafics3d");
        paintNoClick(btnGrafics3d, countGrafics3d);
        btnGrafics3d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countGrafics3d != 0) {
                    countGrafics3d = saveCount(countGrafics3d, "grafics3d");
                    switchOnClicked(btnGrafics3d, countGrafics3d);
                } else {
                    switchOnClicked(btnGrafics3d, countGrafics3d);
                    countGrafics3d = saveCount(countGrafics3d, "grafics3d");
                }
            }
        });

        countFoto = getCount(countFoto, "foto");
        paintNoClick(btnFoto, countFoto);
        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countFoto != 0) {
                    countFoto = saveCount(countFoto, "foto");
                    switchOnClicked(btnFoto, countFoto);
                } else {
                    switchOnClicked(btnFoto, countFoto);
                    countFoto = saveCount(countFoto, "foto");
                }
            }
        });

        countExpressio = getCount(countExpressio, "expressio");
        paintNoClick(btnExpressio, countExpressio);
        btnExpressio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countExpressio != 0) {
                    countExpressio = saveCount(countExpressio, "expressio");
                    switchOnClicked(btnExpressio, countExpressio);
                } else {
                    switchOnClicked(btnExpressio, countExpressio);
                    countExpressio = saveCount(countExpressio, "expressio");
                }
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
                if (countXarxes != 0) {
                    countXarxes = saveCount(countXarxes, "xarxes");
                    switchOnClicked(btnXarxes, countXarxes);
                } else {
                    switchOnClicked(btnXarxes, countXarxes);
                    countXarxes = saveCount(countXarxes, "xarxes");
                }
            }
        });

        countPmm1 = getCount(countPmm1, "pmm1");
        paintNoClick(btnPmm1, countPmm1);
        btnPmm1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPmm1 != 0) {
                    countPmm1 = saveCount(countPmm1, "pmm1");
                    switchOnClicked(btnPmm1, countPmm1);
                } else {
                    switchOnClicked(btnPmm1, countPmm1);
                    countPmm1 = saveCount(countPmm1, "pmm1");
                }
            }
        });

        countPic3 = getCount(countPic3, "pic3");
        paintNoClick(btnPic3, countPic3);
        btnPic3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPic3 != 0) {
                    countPic3 = saveCount(countPic3, "pic3");
                    switchOnClicked(btnPic3, countPic3);
                } else {
                    switchOnClicked(btnPic3, countPic3);
                    countPic3 = saveCount(countPic3, "pic3");
                }
            }
        });

        countTv = getCount(countTv, "tv");
        paintNoClick(btnTv, countTv);
        btnTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countTv != 0) {
                    countTv = saveCount(countTv, "tv");
                    switchOnClicked(btnTv, countTv);
                } else {
                    switchOnClicked(btnTv, countTv);
                    countTv = saveCount(countTv, "tv");
                }
            }
        });

        countPw1 = getCount(countPw1, "pw1");
        paintNoClick(btnPw1, countPw1);
        btnPw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPw1 != 0) {
                    countPw1 = saveCount(countPw1, "pw1");
                    switchOnClicked(btnPw1, countPw1);
                } else {
                    switchOnClicked(btnPw1, countPw1);
                    countPw1 = saveCount(countPw1, "pw1");
                }
            }
        });

        countPds = getCount(countPds, "pds");
        paintNoClick(btnPds, countPds);
        btnPds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPds != 0) {
                    countPds = saveCount(countPds, "pds");
                    switchOnClicked(btnPds, countPds);
                } else {
                    switchOnClicked(btnPds, countPds);
                    countPds = saveCount(countPds, "pds");
                }
            }
        });

        countDramaturgia = getCount(countDramaturgia, "dramaturgia");
        paintNoClick(btnDramaturgia, countDramaturgia);
        btnDramaturgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDramaturgia != 0) {
                    countDramaturgia = saveCount(countDramaturgia, "dramaturgia");
                    switchOnClicked(btnDramaturgia, countDramaturgia);
                } else {
                    switchOnClicked(btnDramaturgia, countDramaturgia);
                    countDramaturgia = saveCount(countDramaturgia, "dramaturgia");
                }
            }
        });

        countSimulaciofisica = getCount(countSimulaciofisica, "simulaciofisica");
        paintNoClick(btnSimulaciofisica, countSimulaciofisica);
        btnSimulaciofisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countSimulaciofisica != 0) {
                    countSimulaciofisica = saveCount(countSimulaciofisica, "simulaciofisica");
                    switchOnClicked(btnSimulaciofisica, countSimulaciofisica);
                } else {
                    switchOnClicked(btnSimulaciofisica, countSimulaciofisica);
                    countSimulaciofisica = saveCount(countSimulaciofisica, "simulaciofisica");
                }
            }
        });

        countPw2 = getCount(countPw2, "pw2");
        paintNoClick(btnPw2, countPw2);
        btnPw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPw2 != 0) {
                    countPw2 = saveCount(countPw2, "pw2");
                    switchOnClicked(btnPw2, countPw2);
                } else {
                    switchOnClicked(btnPw2, countPw2);
                    countPw2 = saveCount(countPw2, "pw2");
                }
            }
        });

        countPdi = getCount(countPdi, "pdi");
        paintNoClick(btnPdi, countPdi);
        btnPdi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPdi != 0) {
                    countPdi = saveCount(countPdi, "pdi");
                    switchOnClicked(btnPdi, countPdi);
                } else {
                    switchOnClicked(btnPdi, countPdi);
                    countPdi = saveCount(countPdi, "pdi");
                }
            }
        });

        countOm = getCount(countOm, "om");
        paintNoClick(btnOm, countOm);
        btnOm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countOm != 0) {
                    countOm = saveCount(countOm, "om");
                    switchOnClicked(btnOm, countOm);
                } else {
                    switchOnClicked(btnOm, countOm);
                    countOm = saveCount(countOm, "om");
                }
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
                if (countPmm2 != 0) {
                    countPmm2 = saveCount(countPmm2, "pmm2");
                    switchOnClicked(btnPmm2, countPmm2);
                } else {
                    switchOnClicked(btnPmm2, countPmm2);
                    countPmm2 = saveCount(countPmm2, "pmm2");
                }
            }
        });

        countPractiques = getCount(countPractiques, "practiques");
        paintNoClick(btnPractiques, countPractiques);
        btnPractiques.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPractiques != 0) {
                    countPractiques = saveCount(countPractiques, "practiques");
                    switchOnClicked(btnPractiques, countPractiques);
                } else {
                    switchOnClicked(btnPractiques, countPractiques);
                    countPractiques = saveCount(countPractiques, "practiques");
                }
            }
        });

        countPdap = getCount(countPdap, "pdap");
        paintNoClick(btnPdap, countPdap);
        btnPdap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPdap != 0) {
                    countPdap = saveCount(countPdap, "pdap");
                    switchOnClicked(btnPdap, countPdap);
                } else {
                    switchOnClicked(btnPdap, countPdap);
                    countPdap = saveCount(countPdap, "pdap");
                }
            }
        });

        countIrv = getCount(countIrv, "irv");
        paintNoClick(btnIrv, countIrv);
        btnIrv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countIrv != 0) {
                    countIrv = saveCount(countIrv, "irv");
                    switchOnClicked(btnIrv, countIrv);
                } else {
                    switchOnClicked(btnIrv, countIrv);
                    countIrv = saveCount(countIrv, "irv");
                }
            }
        });

        countTv_int = getCount(countTv_int, "tv_int");
        paintNoClick(btnTv_int, countTv_int);
        btnTv_int.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countTv_int != 0) {
                    countTv_int = saveCount(countTv_int, "tv_int");
                    switchOnClicked(btnTv_int, countTv_int);
                } else {
                    switchOnClicked(btnTv_int, countTv_int);
                    countTv_int = saveCount(countTv_int, "tv_int");
                }
            }
        });

        countPm = getCount(countPm, "pm");
        paintNoClick(btnPm, countPm);
        btnPm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPm != 0) {
                    countPm = saveCount(countPm, "pm");
                    switchOnClicked(btnPm, countPm);
                } else {
                    switchOnClicked(btnPm, countPm);
                    countPm = saveCount(countPm, "pm");
                }
            }
        });

        countTFG = getCount(countTFG, "tfg");
        paintNoClick(btnTFG, countTFG);
        btnTFG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countTFG != 0) {
                    countTFG = saveCount(countTFG, "tfg");
                    switchOnClicked(btnTFG, countTFG);
                } else {
                    switchOnClicked(btnTFG, countTFG);
                    countTFG = saveCount(countTFG, "tfg");
                }
            }
        });

        countTtecn = getCount(countTtecn, "ttecn");
        paintNoClick(btnTtecn, countTtecn);
        btnTtecn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countTtecn != 0) {
                    countTtecn = saveCount(countTtecn, "ttecn");
                    switchOnClicked(btnTtecn, countTtecn);
                } else {
                    switchOnClicked(btnTtecn, countTtecn);
                    countTtecn = saveCount(countTtecn, "ttecn");
                }
            }
        });

        countEntrepreneurship = getCount(countEntrepreneurship, "entrepreneurship");
        paintNoClick(btnEntrepreneurship, countEntrepreneurship);
        btnEntrepreneurship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countEntrepreneurship != 0) {
                    countEntrepreneurship = saveCount(countEntrepreneurship, "entrepreneurship");
                    switchOnClicked(btnEntrepreneurship, countEntrepreneurship);
                } else {
                    switchOnClicked(btnEntrepreneurship, countEntrepreneurship);
                    countEntrepreneurship = saveCount(countEntrepreneurship, "entrepreneurship");
                }
            }
        });

        btnPrpr1 = (Button) findViewById(R.id.prpr1);
        btnPrpr2 = (Button) findViewById(R.id.prpr2);
        btnMarketing = (Button) findViewById(R.id.marketing);
        btnMarketingSimu = (Button) findViewById(R.id.marketingsimulations);
        btn_iOS = (Button) findViewById(R.id.ios);
        btnPaed = (Button) findViewById(R.id.paed);
        btnIntensiProg = (Button) findViewById(R.id.intensi_prog);

        countPrpr1 = getCount(countPrpr1, "prpr1");
        paintNoClick(btnPrpr1, countPrpr1);
        btnPrpr1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPrpr1 != 0) {
                    countPrpr1 = saveCount(countPrpr1, "prpr1");
                    switchOnClicked(btnPrpr1, countPrpr1);
                } else {
                    switchOnClicked(btnPrpr1, countPrpr1);
                    countPrpr1 = saveCount(countPrpr1, "prpr1");
                }
            }
        });

        countPrpr2 = getCount(countPrpr2, "prpr2");
        paintNoClick(btnPrpr2, countPrpr2);
        btnPrpr2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countPrpr2 != 0) {
                    countPrpr2 = saveCount(countPrpr2, "prpr2");
                    switchOnClicked(btnPrpr2, countPrpr2);
                } else {
                    switchOnClicked(btnPrpr2, countPrpr2);
                    countPrpr2 = saveCount(countPrpr2, "prpr2");
                }
            }
        });

        countMarketing = getCount(countMarketing, "marketing");
        paintNoClick(btnMarketing, countMarketing);
        btnMarketing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countMarketing != 0) {
                    countMarketing = saveCount(countMarketing, "marketing");
                    switchOnClicked(btnMarketing, countMarketing);
                } else {
                    switchOnClicked(btnMarketing, countMarketing);
                    countMarketing = saveCount(countMarketing, "marketing");
                }
            }
        });

        countMarketingSimu = getCount(countMarketingSimu, "marketing_simu");
        paintNoClick(btnMarketingSimu, countMarketingSimu);
        btnMarketingSimu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countMarketingSimu != 0) {
                    countMarketingSimu = saveCount(countMarketingSimu, "marketing_simu");
                    switchOnClicked(btnMarketingSimu, countMarketingSimu);
                } else {
                    switchOnClicked(btnMarketingSimu, countMarketingSimu);
                    countMarketingSimu = saveCount(countMarketingSimu, "marketing_simu");
                }
            }
        });

        count_iOS = getCount(count_iOS, "ios");
        paintNoClick(btn_iOS, count_iOS);
        btn_iOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count_iOS != 0) {
                    count_iOS = saveCount(count_iOS, "ios");
                    switchOnClicked(btn_iOS, count_iOS);
                } else {
                    switchOnClicked(btn_iOS, count_iOS);
                    count_iOS = saveCount(count_iOS, "ios");
                }
            }
        });

        count_paed = getCount(count_paed, "paed");
        paintNoClick(btnPaed, count_paed);
        btnPaed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count_paed != 0) {
                    count_paed = saveCount(count_paed, "paed");
                    switchOnClicked(btnPaed, count_paed);
                } else {
                    switchOnClicked(btnPaed, count_paed);
                    count_paed = saveCount(count_paed, "paed");
                }
            }
        });

        count_intensiProg = getCount(count_intensiProg, "paed");
        paintNoClick(btnIntensiProg, count_intensiProg);
        btnIntensiProg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (count_intensiProg != 0) {
                    count_intensiProg = saveCount(count_intensiProg, "paed");
                    switchOnClicked(btnIntensiProg, count_intensiProg);
                } else {
                    switchOnClicked(btnIntensiProg, count_intensiProg);
                    count_intensiProg = saveCount(count_intensiProg, "paed");
                }
            }
        });

        btnReset = (Button) findViewById(R.id.btnreset);
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                save.putInt("red", 0);
                save.putInt("green", 0);
                save.putInt("blue", 0);
                save.apply();

                tvRed.setText("" + 0 + "");
                tvBlue.setText("" + 0 + "");
                tvGreen.setText("" + 0 + "");

                paintNoClick(btnCalcul, -1);
                paintNoClick(btnElectro, -1);
                paintNoClick(btnProg, -1);
                paintNoClick(btnAlgebra, -1);
                paintNoClick(btnIO, -1);
                paintNoClick(btnBusiness, -1);
                paintNoClick(btnDiu, -1);
                paintNoClick(btnPic, -1);

                paintNoClick(btnMates, -1);
                paintNoClick(btnTrans, -1);
                paintNoClick(btnDpoo, -1);
                paintNoClick(btnBases, -1);
                paintNoClick(btnDiu2, -1);
                paintNoClick(btnLlenguatge, -1);
                paintNoClick(btnAnimacio3d, -1);
                paintNoClick(btnPic2, -1);
                paintNoClick(btnValue, -1);
                paintNoClick(btnGrafics3d, -1);
                paintNoClick(btnFoto, -1);
                paintNoClick(btnExpressio, -1);

                paintNoClick(btnXarxes, -1);
                paintNoClick(btnPmm1, -1);
                paintNoClick(btnPic3, -1);
                paintNoClick(btnTv, -1);
                paintNoClick(btnPw1, -1);
                paintNoClick(btnPds, -1);
                paintNoClick(btnDramaturgia, -1);
                paintNoClick(btnSimulaciofisica, -1);
                paintNoClick(btnPw2, -1);
                paintNoClick(btnPdi, -1);
                paintNoClick(btnOm, -1);

                paintNoClick(btnPmm2, -1);
                paintNoClick(btnPractiques, -1);
                paintNoClick(btnPdap, -1);
                paintNoClick(btnIrv, -1);
                paintNoClick(btnTv_int, -1);
                paintNoClick(btnPm, -1);
                paintNoClick(btnTFG, -1);
                paintNoClick(btnTtecn, -1);
                paintNoClick(btnEntrepreneurship, -1);

                paintNoClick(btnPrpr1, -1);
                paintNoClick(btnPrpr2, -1);
                paintNoClick(btnMarketing, -1);
                paintNoClick(btnMarketingSimu, -1);
                paintNoClick(btn_iOS, -1);
                paintNoClick(btnPaed, -1);
                paintNoClick(btnIntensiProg, -1);

                countCalcul = saveCount(-1, "calcul");
                countElectro = saveCount(-1, "electro");
                countProg = saveCount(-1, "prog");
                countAlgebra = saveCount(-1, "algebra");
                countIO = saveCount(-1, "io");
                countBusiness = saveCount(-1, "business");
                countDiu = saveCount(-1, "diu");
                countPic = saveCount(-1, "pic");

                countMates = saveCount(-1, "mates");
                countTrans = saveCount(-1, "trans");
                countDpoo = saveCount(-1, "dpoo");
                countBases = saveCount(-1, "bases");
                countDiu2 = saveCount(-1, "diu2");
                countLlenguatge = saveCount(-1, "llenguatge");
                countAnimacio3d = saveCount(-1, "animacio3d");
                countPic2 = saveCount(-1, "pic2");
                countValue = saveCount(-1, "value");
                countGrafics3d = saveCount(-1, "grafics3d");
                countFoto = saveCount(-1, "foto");
                countExpressio = saveCount(-1, "expressio");

                countXarxes = saveCount(-1, "xarxes");
                countPmm1 = saveCount(-1, "pmm1");
                countPic3 = saveCount(-1, "pic3");
                countTv = saveCount(-1, "tv");
                countPw1 = saveCount(-1, "pw1");
                countPds = saveCount(-1, "pds");
                countDramaturgia = saveCount(-1, "dramaturgia");
                countSimulaciofisica = saveCount(-1, "simulaciofisica");
                countPw2 = saveCount(-1, "pw2");
                countPdi = saveCount(-1, "pdi");
                countOm = saveCount(-1, "om");

                countPmm2 = saveCount(-1, "pmm2");
                countPractiques = saveCount(-1, "practiques");
                countPdap = saveCount(-1, "pdap");
                countIrv = saveCount(-1, "irv");
                countTv_int = saveCount(-1, "tv_int");
                countPm = saveCount(-1, "pm");
                countTFG = saveCount(-1, "tfg");
                countTtecn = saveCount(-1, "ttecn");
                countEntrepreneurship = saveCount(-1, "entrepreneurship");

                countPrpr1 = saveCount(-1, "prpr1");
                countPrpr2 = saveCount(-1, "prpr2");
                countMarketing = saveCount(-1, "marketing");
                countMarketingSimu = saveCount(-1, "marketing_simu");
                count_iOS = saveCount(-1, "ios");
                count_paed = saveCount(-1, "paed");
                count_intensiProg = saveCount(-1, "intensi_prog");

                numBlue = 0;
                numGreen = 0;
                numRed = 0;
            }
        });
    }
}


