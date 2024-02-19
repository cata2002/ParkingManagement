package models;

import views.DatabaseMethods;
import views.ParkingView;

public class Parking {

    public int [][]block1=new int[9][9];
    public int [][]block2=new int[9][9];
    public int  [][]block3=new int[9][9];


    public Parking() {
        DatabaseMethods date=new DatabaseMethods();
        date.computeAlreadyParked1();
        date.computeAlreadyParked2();
        date.computeAlreadyParked3();
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                if(i==0 || j==0) block1[i][j]=block2[i][j]=block3[i][j]=-1;
                    else block1[i][j]=block2[i][j]=block3[i][j]=0;
        int i=0;
        while(date.rows1[i]!=0){
           block1[date.rows1[i]][date.columns1[i]]=1;
           i++;
        }
        i=0;
        while(date.rows2[i]!=0){
            block2[date.rows2[i]][date.columns2[i]]=1;
            i++;
        }
        i=0;
        while(date.rows3[i]!=0){
            block3[date.rows3[i]][date.columns3[i]]=1;
            i++;
        }
    }

    public int addCar(int blockNr, int row, int col){
        if(blockNr==1){
            if(block1[row][col]==0){
                block1[row][col]=1;
                return 1;
            }else return 0;
        }else if(blockNr==2){
            if(block2[row][col]==0){
                block2[row][col]=1;
                return 1;
            }else return 0;
        }else if(blockNr==3){
            if(block3[row][col]==0){
                block3[row][col]=1;
                return 1;
            }else return 0;
        }
        return 0;
    }

    public int checkNrOfSlots(int blockNr){
        int nr1=0, nr2=0, nr3=0;
        if(blockNr==1){
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    if(block1[i][j]==1)nr1++;
            return 64-nr1;
        }else if(blockNr==2){
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    if(block2[i][j]==1)nr2++;
            return 64-nr2;
        }else{
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    if(block3[i][j]==1)nr3++;
            return 64-nr3;
        }
    }

    public int checkSlot(int blockNr, int row, int col){
        if((blockNr==1 && block1[row][col]==0) || (blockNr==2 && block2[row][col]==0) || (blockNr==3 && block3[row][col]==0))return 1;
        else return 0;
    }

    public int checkValidPlate(String str){
        int nrd = 0, nrLet=0;
        for(int i=0; i<str.length(); i++){
            if(Character.isDigit(str.charAt(i))) nrd++;
            else if(Character.isAlphabetic(str.charAt(i))) nrLet++;
        }
        if(nrd>0 && nrLet>0) return 1;
        return 0;
    }

    public int computeFee(int hours){
        return 20*hours;
    }

    public int computeContactNumber(String name){
        int sum=0;
        for(int i=0;i<name.length();i++){
            char c=name.charAt(i);
            sum+=(int)(c);
            sum=sum%23197;
        }
        return sum;
    }
}
