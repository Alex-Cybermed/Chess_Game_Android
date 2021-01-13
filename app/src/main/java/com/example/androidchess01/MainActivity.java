/**
 * @author Xiang Ao, Shijie Xu
 * @since May 1st, 2019
 * <p>
 * This class main activity
 * <p>
 * CS213 Software Methodology Project 4: A playable chess on Android.
 */
package com.example.androidchess01;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.io.*;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    // this is file saved path
    public String savePath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/chess";


    static InitialBoard ib = new InitialBoard();
    static PrintBoard pb = new PrintBoard();
    static SetPiece sp = new SetPiece();
    static SpecialMovement sm = new SpecialMovement();
    static Checkmate cm = new Checkmate();
    static ArrayList<BlockNode> board;
    ArrayList<String> steps = new ArrayList<>(); //recording
    ArrayList<String> game = new ArrayList<>();  // game name
    static ArrayList<ImageView> imageViewBoardList;
    static int clickTime = 0;
    static String select_string = "";
    static String target_string = "";
    static String promo_string = "NA";
    static String output = "";
    static int info = 0;
    static String promoInfo = "";
    static boolean whiteRound = true; //default: white player must play the first move
    String fileName;
    int i = 0;

    @BindView(R.id.iv0)
    ImageView iv0;
    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.iv5)
    ImageView iv5;
    @BindView(R.id.iv6)
    ImageView iv6;
    @BindView(R.id.iv7)
    ImageView iv7;
    @BindView(R.id.iv8)
    ImageView iv8;
    @BindView(R.id.iv9)
    ImageView iv9;
    @BindView(R.id.iv10)
    ImageView iv10;
    @BindView(R.id.iv11)
    ImageView iv11;
    @BindView(R.id.iv12)
    ImageView iv12;
    @BindView(R.id.iv13)
    ImageView iv13;
    @BindView(R.id.iv14)
    ImageView iv14;
    @BindView(R.id.iv15)
    ImageView iv15;
    @BindView(R.id.iv16)
    ImageView iv16;
    @BindView(R.id.iv17)
    ImageView iv17;
    @BindView(R.id.iv18)
    ImageView iv18;
    @BindView(R.id.iv19)
    ImageView iv19;
    @BindView(R.id.iv20)
    ImageView iv20;
    @BindView(R.id.iv21)
    ImageView iv21;
    @BindView(R.id.iv22)
    ImageView iv22;
    @BindView(R.id.iv23)
    ImageView iv23;
    @BindView(R.id.iv24)
    ImageView iv24;
    @BindView(R.id.iv25)
    ImageView iv25;
    @BindView(R.id.iv26)
    ImageView iv26;
    @BindView(R.id.iv27)
    ImageView iv27;
    @BindView(R.id.iv28)
    ImageView iv28;
    @BindView(R.id.iv29)
    ImageView iv29;
    @BindView(R.id.iv30)
    ImageView iv30;
    @BindView(R.id.iv31)
    ImageView iv31;
    @BindView(R.id.iv32)
    ImageView iv32;
    @BindView(R.id.iv33)
    ImageView iv33;
    @BindView(R.id.iv34)
    ImageView iv34;
    @BindView(R.id.iv35)
    ImageView iv35;
    @BindView(R.id.iv36)
    ImageView iv36;
    @BindView(R.id.iv37)
    ImageView iv37;
    @BindView(R.id.iv38)
    ImageView iv38;
    @BindView(R.id.iv39)
    ImageView iv39;
    @BindView(R.id.iv40)
    ImageView iv40;
    @BindView(R.id.iv41)
    ImageView iv41;
    @BindView(R.id.iv42)
    ImageView iv42;
    @BindView(R.id.iv43)
    ImageView iv43;
    @BindView(R.id.iv44)
    ImageView iv44;
    @BindView(R.id.iv45)
    ImageView iv45;
    @BindView(R.id.iv46)
    ImageView iv46;
    @BindView(R.id.iv47)
    ImageView iv47;
    @BindView(R.id.iv48)
    ImageView iv48;
    @BindView(R.id.iv49)
    ImageView iv49;
    @BindView(R.id.iv50)
    ImageView iv50;
    @BindView(R.id.iv51)
    ImageView iv51;
    @BindView(R.id.iv52)
    ImageView iv52;
    @BindView(R.id.iv53)
    ImageView iv53;
    @BindView(R.id.iv54)
    ImageView iv54;
    @BindView(R.id.iv55)
    ImageView iv55;
    @BindView(R.id.iv56)
    ImageView iv56;
    @BindView(R.id.iv57)
    ImageView iv57;
    @BindView(R.id.iv58)
    ImageView iv58;
    @BindView(R.id.iv59)
    ImageView iv59;
    @BindView(R.id.iv60)
    ImageView iv60;
    @BindView(R.id.iv61)
    ImageView iv61;
    @BindView(R.id.iv62)
    ImageView iv62;
    @BindView(R.id.iv63)
    ImageView iv63;
    @BindView(R.id.start3)
    Button start_button;
    @BindView(R.id.Knight)
    Button knightPromo;
    @BindView(R.id.Bishop)
    Button bishopPromo;
    @BindView(R.id.Rook)
    Button rookPromo;
    @BindView(R.id.Queen)
    Button queenPromo;
    @BindView(R.id.save)
    Button save;
    @BindView(R.id.next)
    Button next;
    @BindView(R.id.cancel)
    Button cancel;
    @BindView(R.id.undo)
    Button undo;
    @BindView(R.id.ai)
    Button ai;
    @BindView(R.id.resign)
    Button resign;
    @BindView(R.id.draw)
    Button draw;
    @BindView(R.id.reset)
    Button reset;
    @BindView(R.id.history)
    Button history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ButterKnife.bind(this);
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            // Storage Permission Request
            int REQUEST_EXTERNAL_STORAGE = 1;
            String[] PERMISSIONS_STORAGE = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };
            int permission = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

            if (permission != PackageManager.PERMISSION_GRANTED) {
                // We don't have permission so prompt the user
                ActivityCompat.requestPermissions(
                        MainActivity.this,
                        PERMISSIONS_STORAGE,
                        REQUEST_EXTERNAL_STORAGE
                );
            }
            File dir = new File(savePath);
            dir.mkdirs();
            File p = new File("sdcard/chess/gamerecord");
            p.createNewFile();
            game = loadNameList();
            if(game== null){
                game = new ArrayList<>();
                game.add("0");
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void pieceClick(View v) {
        clickTime++;
        int select, move;
        if (clickTime == 1) {
            if (!clickRightPiece(v.getTag().toString(), whiteRound)) {
                //click wrong block
                pl("first click wrong");
                clickTime = 0;
                return;
            } else {
                select_string = v.getTag().toString();
                pl("first click correct");
                return;
            }
        } else if (clickTime == 2) {
            if (clickRightPiece(v.getTag().toString(), whiteRound)) {
                clickTime = 1;
                pl("second click wrong");
                return;
            } else {
                pl("second click correct");
                target_string = v.getTag().toString();
            }
            cm.clearCheckStatus(board);
            if (!cm.checkCheck(cm.kingFinder(whiteRound, board), false, board)) {
                if (!cm.checkAround(cm.kingFinder(whiteRound, board), board)
                        && !cm.protectKing(cm.kingFinder(whiteRound, board), board)) {
                    pl("Black wins: " + whiteRound);
                    return;
                }
            }
            if (info == 2) {
                output = aiMove();
            } else {
                output = select_string + target_string;
                select = stringToIndex(output.substring(0, 2));
                move = stringToIndex(output.substring(2, 4));
                sm.checkEnpassant(whiteRound, board);
                if (sm.castling(select, move, board)) {
                    pb.printBoard(board);
                    nodeToImage(board, true);
                    clickTime = 0;
                } else if (sp.fileRank(whiteRound, select, move, board)) {
                    sm.promotion(move, promo_string, board);
                    pb.printBoard(board);
                    nodeToImage(board, true);
                } else {
                    clickTime = 0;
                    return;
                }
            }

            if(output!=null) {
                steps.add(output);
            }
            clickTime = 0;
            //turn side
            if (whiteRound) {
                whiteRound = false;
            } else {
                whiteRound = true;
            }
            nodeToImage(board, true);
            if (cm.kingFinder(!whiteRound, board) == -1) {
                pl("White wins: " + whiteRound);
                return;
            }
            cm.checkCheck(cm.kingFinder(whiteRound, board), true, board);
            cm.checkCheck(cm.kingFinder(!whiteRound, board), true, board);
        }
    }




    public void gameEnd(){
        // Storage Permission check
        int REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        final EditText edt = new EditText(this);
        edt.setHint("Please enter record title");
        edt.setSingleLine(true);
        builder.setView(edt);
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


//                pl(savePath);
                String fileName = edt.getText().toString();
                File file = new File("/sdcard/chess/" + fileName );
                File p = new File("/sdcard/chess/gamerecord");
                game.add(fileName);
                saveRecord(steps, file);

                saveRecord(game,p);
//                saveBoardToFile(board, file);
                Toast.makeText(MainActivity.this, "Record Successfully Saved", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(false);//使除了dialog以外的地方不能被点击
        alert.show();
    }
    /**
     * transfer BlockNode type ArrayList to ImageView type ArrayList
     *
     * @param board
     */
    public void nodeToImage(ArrayList<BlockNode> board, boolean refresh) {
        if (!refresh) {
            initialImageViewList();
        }
        String role = "";
        for (int i = 0; i < 64; i++) {
            if (board.get(i).getPiece() == null) {
                imageViewBoardList.get(i).setImageResource(R.drawable.animation);
            } else {
                role = board.get(i).getPiece().getRole();
                if (board.get(i).getPiece().getColor() == 1) {
                    switch (role) {
                        case "R":
                            imageViewBoardList.get(i).setImageResource(R.drawable.wr);
                            break;
                        case "N":
                            imageViewBoardList.get(i).setImageResource(R.drawable.wn);
                            break;
                        case "B":
                            imageViewBoardList.get(i).setImageResource(R.drawable.wb);
                            break;
                        case "Q":
                            imageViewBoardList.get(i).setImageResource(R.drawable.wq);
                            break;
                        case "K":
                            imageViewBoardList.get(i).setImageResource(R.drawable.wk);
                            break;
                        case "p":
                            imageViewBoardList.get(i).setImageResource(R.drawable.wp);
                            break;
                    }
                } else {
                    switch (role) {
                        case "R":
                            imageViewBoardList.get(i).setImageResource(R.drawable.br);
                            break;
                        case "N":
                            imageViewBoardList.get(i).setImageResource(R.drawable.bn);
                            break;
                        case "B":
                            imageViewBoardList.get(i).setImageResource(R.drawable.bb);
                            break;
                        case "Q":
                            imageViewBoardList.get(i).setImageResource(R.drawable.bq);
                            break;
                        case "K":
                            imageViewBoardList.get(i).setImageResource(R.drawable.bk);
                            break;
                        case "p":
                            imageViewBoardList.get(i).setImageResource(R.drawable.bp);
                            break;
                    }
                }
            }
        }
    }

    /**
     * redirected function for main buttons
     *
     * @param view button clicked
     */
    public void buttons(View view) {
        switch (view.getTag().toString()) {
            case "save":
                saveButton();
                break;
            case "start":
                startButton();
                break;
            case "reset":
                resetButton();
                break;
            case "history":
                historyButton();
                break;
            case "undo":
                undoButton();
                break;
            case "ai":
                info = 2;
                clickTime = 2;
                break;
            case "draw":
                drawButton();
                break;
            case "resign":
                resignButton();
                break;
        }
    }

    public void viewRecord(View view){
        switch (view.getTag().toString()){
            case "next":
                next_viewRecord();
                break;
            case "leave":
                cancel_viewRecord();
                break;
        }
    }
    public void next_viewRecord(){
        if(i==0){
            board = ib.initial();
            nodeToImage(board, false);
        }
        File file = new File("/sdcard/chess/" +fileName);
        steps = loadRecord(file);
        String tmp = steps.get(i);
        String first = tmp.substring(0,2);
        String second = tmp.substring(2,4);
        ImageView firstIV;
        ImageView secondIV;
        for(int i = 0; i < 64;i++ ){
            String tmptag = imageViewBoardList.get(i).getTag().toString();
            if(tmptag==first){
                firstIV = imageViewBoardList.get(i);
            }
            if(tmptag== second){
                secondIV = imageViewBoardList.get(i);
            }
        }

    }

    public void cancel_viewRecord(){
        next.setVisibility(View.INVISIBLE);
        cancel.setVisibility(View.INVISIBLE);
        undo.setVisibility(View.VISIBLE);
        ai.setVisibility(View.VISIBLE);
        resign.setVisibility(View.VISIBLE);
        draw.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
        start_button.setVisibility(View.VISIBLE);
        save.setVisibility(View.VISIBLE);
        history.setVisibility(View.VISIBLE);
    }
    /**
     * initial a new board
     */
    public void startButton() {
        whiteRound = true;
        board = ib.initial();
        nodeToImage(board, false);
        clickTime = 0;
    }

    /**
     * reset board with no piece on it.
     */
    public void resetButton() {
        whiteRound = true;
        board = ib.initial();
        nodeToImage(board, false);
        nodeToImage(board, true);
        clickTime = 0;
    }

    public void saveButton(){
        // Storage Permission check
        int REQUEST_EXTERNAL_STORAGE = 1;
        String[] PERMISSIONS_STORAGE = {
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        int permission = ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    MainActivity.this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Save Game");
        final EditText edt = new EditText(this);
        edt.setHint("Please enter game name");
        edt.setSingleLine(true);
        builder.setView(edt);
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Save", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


//                pl(savePath);
                String fileName = edt.getText().toString();
                File file = new File("/sdcard/chess/" + fileName );
                File p = new File("/sdcard/chess/gamerecord");
                game.add(fileName);
                saveRecord(steps, file);
                saveRecord(game,p);
//                saveBoardToFile(board, file);
                Toast.makeText(MainActivity.this, "Game Successfully Saved", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(false);//使除了dialog以外的地方不能被点击
        alert.show();
    }
    public void saveRecord(ArrayList<String> steps, File file){
        try {

            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));

            oos.writeObject(steps);                 //将BlockNode对象board写入到oos中

            oos.close();                        //关闭文件流
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public ArrayList<String> loadRecord(File file){
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));

            ArrayList<String> steps=(ArrayList<String>) ois.readObject();              //读出对象

            return steps;                                       //返回对象
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        return null;
    }
    public ArrayList<String> loadNameList(){
        try {
            File p = new File("sdcard/chess/gamerecord");
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(p));

            ArrayList<String> name=(ArrayList<String>) ois.readObject();              //读出对象

            return name;                                       //返回对象
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        return null;
    }
    public void saveBoardToFile(ArrayList<BlockNode> board, File file){
        try {

            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(file));

            oos.writeObject(board);                 //将BlockNode对象board写入到oos中

            oos.close();                        //关闭文件流
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public ArrayList<BlockNode> loadBoardFromFile(File file){
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(file));

            ArrayList<BlockNode> readBoard=(ArrayList<BlockNode>) ois.readObject();              //读出对象

            return readBoard;                                       //返回对象
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        return null;
    }
    public void undoButton() {
        info = 1;
    }

    public void aiButton() {

        aiMove();
    }

    public boolean drawButton() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Draw");
        builder.setMessage("Draw");
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "You choose to draw, game over", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                gameEnd();
            }
        });
        builder.show();
        info = 3;
        return true;
    }

    public boolean resignButton() {
        String msg;
        if(whiteRound){
            msg = "Black win!";
        }
        else{
            msg = "White win";
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Resign");
        builder.setMessage("Round Resigned! "+ msg);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Game Over", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                gameEnd();
            }
        });
        builder.show();
        info = 4;
        return true;
    }

    public void historyButton() {
        /*
        display history records in another activity.
         */
        AlertDialog.Builder builderSingle = new AlertDialog.Builder(this);
        builderSingle.setTitle("Game History");
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice);

        if(game!=null) {
            for (int i = 1; i < game.size(); i++) {
                adapter.add(game.get(i));
            }
        }


        builderSingle.setAdapter(adapter,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectFile = adapter.getItem(which);
                        fileName = selectFile;
                        next.setVisibility(View.VISIBLE);
                        cancel.setVisibility(View.VISIBLE);
                        undo.setVisibility(View.INVISIBLE);
                        ai.setVisibility(View.INVISIBLE);
                        resign.setVisibility(View.INVISIBLE);
                        draw.setVisibility(View.INVISIBLE);
                        reset.setVisibility(View.INVISIBLE);
                        start_button.setVisibility(View.INVISIBLE);
                        save.setVisibility(View.INVISIBLE);
                        history.setVisibility(View.INVISIBLE);


                    }
                });



        builderSingle.setNegativeButton("cancel",
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builderSingle.setPositiveButton("Play", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builderSingle.create();
        builderSingle.show();
    }

    public void promo(View view) {
        String promoRole = view.getTag().toString();
        switch (promoRole) {
            case "knight":
                promo_string = "N";
                break;
            case "bishop":
                promo_string = "B";
                break;
            case "rook":
                promo_string = "R";
                break;
            case "queen":
                promo_string = "Q";
                break;
            default:
                promo_string = "";
                break;
        }
    }

    public String aiMove() {
        String select;
        String move;
        String output;
        if (whiteRound) {
            for (int i = 0; i < 64; i++) {
                if (board.get(i).getPiece() != null) {
                    if (board.get(i).getPiece().getColor() == 1) {
                        select = String.valueOf(i);
                        if (board.get(i).getPiece().getNextPos() != null) {
                            if (!board.get(i).getPiece().getNextPos().isEmpty()) {
                                move = String.valueOf(board.get(i).getPiece().getNextPos().get(0));
                                output = select + move;
                                info = 0;
                                return output;
                            }
                        }

                    }
                }
            }
        } else {
            for (int i = 0; i < 64; i++) {
                if (board.get(i).getPiece() != null) {
                    if (board.get(i).getPiece().getColor() == 2) {
                        select = String.valueOf(i);
                        if (board.get(i).getPiece().getNextPos() != null) {
                            if (!board.get(i).getPiece().getNextPos().isEmpty()) {
                                move = String.valueOf(board.get(i).getPiece().getNextPos().get(0));
                                output = select + move;
                                info = 0;
                                return output;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * initial an ArrayList<ImageView> with 64 size transparent images.
     */
    public void initialImageViewList() {
        imageViewBoardList = new ArrayList<ImageView>();
        imageViewBoardList.add(iv0);
        imageViewBoardList.add(iv1);
        imageViewBoardList.add(iv2);
        imageViewBoardList.add(iv3);
        imageViewBoardList.add(iv4);
        imageViewBoardList.add(iv5);
        imageViewBoardList.add(iv6);
        imageViewBoardList.add(iv7);
        imageViewBoardList.add(iv8);
        imageViewBoardList.add(iv9);
        imageViewBoardList.add(iv10);
        imageViewBoardList.add(iv11);
        imageViewBoardList.add(iv12);
        imageViewBoardList.add(iv13);
        imageViewBoardList.add(iv14);
        imageViewBoardList.add(iv15);
        imageViewBoardList.add(iv16);
        imageViewBoardList.add(iv17);
        imageViewBoardList.add(iv18);
        imageViewBoardList.add(iv19);
        imageViewBoardList.add(iv20);
        imageViewBoardList.add(iv21);
        imageViewBoardList.add(iv22);
        imageViewBoardList.add(iv23);
        imageViewBoardList.add(iv24);
        imageViewBoardList.add(iv25);
        imageViewBoardList.add(iv26);
        imageViewBoardList.add(iv27);
        imageViewBoardList.add(iv28);
        imageViewBoardList.add(iv29);
        imageViewBoardList.add(iv30);
        imageViewBoardList.add(iv31);
        imageViewBoardList.add(iv32);
        imageViewBoardList.add(iv33);
        imageViewBoardList.add(iv34);
        imageViewBoardList.add(iv35);
        imageViewBoardList.add(iv36);
        imageViewBoardList.add(iv37);
        imageViewBoardList.add(iv38);
        imageViewBoardList.add(iv39);
        imageViewBoardList.add(iv40);
        imageViewBoardList.add(iv41);
        imageViewBoardList.add(iv42);
        imageViewBoardList.add(iv43);
        imageViewBoardList.add(iv44);
        imageViewBoardList.add(iv45);
        imageViewBoardList.add(iv46);
        imageViewBoardList.add(iv47);
        imageViewBoardList.add(iv48);
        imageViewBoardList.add(iv49);
        imageViewBoardList.add(iv50);
        imageViewBoardList.add(iv51);
        imageViewBoardList.add(iv52);
        imageViewBoardList.add(iv53);
        imageViewBoardList.add(iv54);
        imageViewBoardList.add(iv55);
        imageViewBoardList.add(iv56);
        imageViewBoardList.add(iv57);
        imageViewBoardList.add(iv58);
        imageViewBoardList.add(iv59);
        imageViewBoardList.add(iv60);
        imageViewBoardList.add(iv61);
        imageViewBoardList.add(iv62);
        imageViewBoardList.add(iv63);
    }

    /**
     * Transfer string to int input
     *
     * @param input fileRank String
     * @return fileRank integar input
     */
    public int stringToIndex(String input) {
        int selectLetter = (int) input.charAt(0) - 97;
        int selectNumber = 7 - ((int) input.charAt(1) - 49);
        int out = selectNumber * 8 + selectLetter;
        return out;
    }

//    public int returnRolesColor(String fileRank) {
//        int role = 0;
//        int roleInd = stringToIndex(fileRank);
//        if (board.get(roleInd).getPiece() != null) {
//            role = board.get(roleInd).getPiece().getColor();
//        }
//        return role;
//    }
//
//    public String returnRole(String fileRank) {
//        String role = "";
//        int roleInd = stringToIndex(fileRank);
//        if (board.get(roleInd).getPiece() != null) {
//            role = board.get(roleInd).getPiece().getRole();
//        }
//        return role;
//    }

    /**
     * Check the right piece that user selected
     *
     * @param fileRank the position user click
     * @param white    check if its white
     * @return
     */
    public boolean clickRightPiece(String fileRank, boolean white) {
        int roleInd = stringToIndex(fileRank);
        if (board.get(roleInd).getPiece() != null) {
            if (white) {
                if (board.get(roleInd).getPiece().getColor() == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (board.get(roleInd).getPiece().getColor() == 2) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
    }

    public static void setClickTime(int click) {
        clickTime = click;
    }

    /**
     * Print helper method
     *
     * @param msg The message you want to print.
     */
    public static void p(String msg) {
        System.out.print(msg);
    }

    /**
     * Print helper method
     *
     * @param msg The message you want to print in a line.
     */
    public static void pl(String msg) {
        System.out.println(msg);
    }
}
