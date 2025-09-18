/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Custom_Exception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo IP 330-14IKB
 */
class Saldo_Tidak_Cukup extends Exception{
    public Saldo_Tidak_Cukup(String pesan) {
        super(pesan);
    }
}

public class Rekening { //Masih Error
    private double saldo;

    public Rekening(double saldo) {
        this.saldo = saldo;
    }

    public void tarikUang(double jumlah) throws Saldo_Tidak_Cukup { //
        if (jumlah > saldo) {
            throw new Saldo_Tidak_Cukup("Saldo tidak cukup untuk menarik " + jumlah);
        }
        saldo -= jumlah;
        System.out.println("Berhasil tarik uang: " + jumlah);
        System.out.println("Sisa saldo: " + saldo);
    }

    // Main method langsung di dalam class Rekening
    public static void main(String[] args) {
        Rekening rekening = new Rekening(500_000);

        try {
            rekening.tarikUang(200_000); // gagal, saldo kurang
        } catch (Saldo_Tidak_Cukup e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}
