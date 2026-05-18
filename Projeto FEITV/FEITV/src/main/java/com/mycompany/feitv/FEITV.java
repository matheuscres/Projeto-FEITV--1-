/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.feitv;

/**
 *
 * @author Cliente
 */

import com.mycompany.feitv.controller.UsuarioController;
import com.mycompany.feitv.view.TelaInicial;
import javax.swing.SwingUtilities;

public class FEITV {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial tela = new TelaInicial();
            tela.setUsuarioController(new UsuarioController());
            tela.setVisible(true);
        });
    }
}
