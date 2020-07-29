/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author SURYA
 */
public class Tdata {
   private int tid;
   private int uid;
   private int transfer_amount;
   private int deposit_amount;
   private int account_balance;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getTransfer_amount() {
        return transfer_amount;
    }

    public void setTransfer_amount(int transfer_amount) {
        this.transfer_amount = transfer_amount;
    }

    public int getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(int deposit_amount) {
        this.deposit_amount = deposit_amount;
    }

    public int getAccount_balance() {
        return account_balance;
    }

    public void setAccount_balance(int account_balance) {
        this.account_balance = account_balance;
    }
 
}
