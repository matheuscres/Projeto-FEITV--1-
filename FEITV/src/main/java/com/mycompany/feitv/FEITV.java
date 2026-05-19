package com.mycompany.feitv;

import com.mycompany.feitv.controller.UsuarioController;
import com.mycompany.feitv.view.TelaInicial;
import javax.swing.SwingUtilities;

/**
 * Classe principal da aplicação FEITV.
 * Inicializa a interface gráfica e os controladores necessários para o funcionamento do sistema.
 */

public class FEITV {

    /**
     * Inicia a aplicação.
     */
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial tela = new TelaInicial();
            tela.setUsuarioController(new UsuarioController());
            tela.setVisible(true);
        });
    }
}
