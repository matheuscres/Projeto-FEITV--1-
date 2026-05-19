package com.mycompany.feitv.view;

import com.mycompany.feitv.controller.ListaController;
import com.mycompany.feitv.controller.UsuarioController;
import com.mycompany.feitv.controller.VideoController;
import com.mycompany.feitv.model.ListaReproducao;
import com.mycompany.feitv.model.SerieFilme;
import com.mycompany.feitv.model.Usuario;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Tela responsável pela interface principal da aplicação FEITV.
 * Recebe as ações do usuário e repassa para os controladores.
 */

public class TelaPrincipal extends javax.swing.JFrame {

    private Usuario usuario = new Usuario(0, "Cliente", "cliente@teste.com", "");
    private VideoController videoController = new VideoController();
    private ListaController listaController = new ListaController();
    private UsuarioController usuarioController = new UsuarioController();

    private DefaultListModel<SerieFilme> videosModel;
    private DefaultListModel<ListaReproducao> playlistsModel;
    private DefaultListModel<SerieFilme> playlistVideosModel;

    /**
     * Construtor padrão que inicializa a tela principal.
     */
    
    public TelaPrincipal() {
        initComponents();
        inicializarModelos();
    }

    /**
     * Preenche a tela principal com os dados informados.
     * @param usuario usuário carregado na tela
     * @param usuarioController controller de usuários
     * @param videoController controller de vídeos
     * @param listaController controller de listas
     */
    
    public void setDados(Usuario usuario, UsuarioController usuarioController,
                         VideoController videoController, ListaController listaController) {
        if (usuario != null) {
            this.usuario = usuario;
        }
        if (usuarioController != null) {
            this.usuarioController = usuarioController;
        }
        if (videoController != null) {
            this.videoController = videoController;
        }
        if (listaController != null) {
            this.listaController = listaController;
        }
        iniciarTela();
    }

    private void iniciarTela() {
        carregarVideos("");
        carregarPlaylists();
        atualizarPerfil();
    }

    private void inicializarModelos() {
        videosModel = new DefaultListModel<>();
        lstVideos.setModel(videosModel);
        playlistsModel = new DefaultListModel<>();
        lstPlaylists.setModel(playlistsModel);
        playlistVideosModel = new DefaultListModel<>();
        lstVideosPlaylist.setModel(playlistVideosModel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelBusca = new javax.swing.JPanel();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDetalhes = new javax.swing.JTextArea();
        btnCurtir = new javax.swing.JButton();
        btnDescurtir = new javax.swing.JButton();
        lblPlaylist = new javax.swing.JLabel();
        cmbPlaylists = new javax.swing.JComboBox();
        btnAdicionarPlaylist = new javax.swing.JButton();
        lblPerfilTitulo2 = new javax.swing.JLabel();
        panelFavoritos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPlaylists = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstVideosPlaylist = new javax.swing.JList();
        btnCriarPlaylist = new javax.swing.JButton();
        btnRenomearPlaylist = new javax.swing.JButton();
        btnExcluirPlaylist = new javax.swing.JButton();
        btnRemoverVideo = new javax.swing.JButton();
        lblPerfilTitulo1 = new javax.swing.JLabel();
        panelPerfil = new javax.swing.JPanel();
        lblPerfilTitulo = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblTotalUsuarios = new javax.swing.JLabel();
        lblTotalVideos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FEItv");

        jTabbedPane1.setBackground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));

        panelBusca.setBackground(new java.awt.Color(51, 51, 51));

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lstVideos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVideosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstVideos);

        txtDetalhes.setEditable(false);
        txtDetalhes.setLineWrap(true);
        txtDetalhes.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtDetalhes);

        btnCurtir.setBackground(new java.awt.Color(0, 153, 51));
        btnCurtir.setText("Curtir");
        btnCurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCurtirActionPerformed(evt);
            }
        });

        btnDescurtir.setBackground(new java.awt.Color(255, 51, 0));
        btnDescurtir.setText("Descurtir");
        btnDescurtir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescurtirActionPerformed(evt);
            }
        });

        lblPlaylist.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        lblPlaylist.setText("Lista de Reprodução:");

        btnAdicionarPlaylist.setText("Adicionar");
        btnAdicionarPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarPlaylistActionPerformed(evt);
            }
        });

        lblPerfilTitulo2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPerfilTitulo2.setForeground(new java.awt.Color(204, 0, 0));
        lblPerfilTitulo2.setText("Menu FEITV");

        javax.swing.GroupLayout panelBuscaLayout = new javax.swing.GroupLayout(panelBusca);
        panelBusca.setLayout(panelBuscaLayout);
        panelBuscaLayout.setHorizontalGroup(
            panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(panelBuscaLayout.createSequentialGroup()
                        .addComponent(btnCurtir)
                        .addGap(8, 8, 8)
                        .addComponent(btnDescurtir)
                        .addGap(8, 8, 8)
                        .addComponent(lblPlaylist)
                        .addGap(8, 8, 8)
                        .addComponent(cmbPlaylists, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdicionarPlaylist))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtBusca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBuscaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblPerfilTitulo2)
                .addGap(294, 294, 294))
        );
        panelBuscaLayout.setVerticalGroup(
            panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBuscaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblPerfilTitulo2)
                .addGap(32, 32, 32)
                .addGroup(panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panelBuscaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCurtir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescurtir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPlaylist)
                    .addComponent(cmbPlaylists, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Menu", panelBusca);

        panelFavoritos.setBackground(new java.awt.Color(51, 51, 51));

        lstPlaylists.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPlaylistsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstPlaylists);

        jScrollPane4.setViewportView(lstVideosPlaylist);

        btnCriarPlaylist.setBackground(new java.awt.Color(51, 102, 255));
        btnCriarPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        btnCriarPlaylist.setText("Criar");
        btnCriarPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarPlaylistActionPerformed(evt);
            }
        });

        btnRenomearPlaylist.setBackground(new java.awt.Color(153, 153, 0));
        btnRenomearPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        btnRenomearPlaylist.setText("Renomear");
        btnRenomearPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenomearPlaylistActionPerformed(evt);
            }
        });

        btnExcluirPlaylist.setBackground(new java.awt.Color(204, 0, 0));
        btnExcluirPlaylist.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirPlaylist.setText("Excluir");
        btnExcluirPlaylist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPlaylistActionPerformed(evt);
            }
        });

        btnRemoverVideo.setBackground(new java.awt.Color(0, 0, 0));
        btnRemoverVideo.setForeground(new java.awt.Color(255, 255, 255));
        btnRemoverVideo.setText("Remover video");
        btnRemoverVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverVideoActionPerformed(evt);
            }
        });

        lblPerfilTitulo1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPerfilTitulo1.setForeground(new java.awt.Color(204, 0, 0));
        lblPerfilTitulo1.setText("Listas de Reproduções (playlists)");

        javax.swing.GroupLayout panelFavoritosLayout = new javax.swing.GroupLayout(panelFavoritos);
        panelFavoritos.setLayout(panelFavoritosLayout);
        panelFavoritosLayout.setHorizontalGroup(
            panelFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFavoritosLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(lblPerfilTitulo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFavoritosLayout.createSequentialGroup()
                .addGroup(panelFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFavoritosLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelFavoritosLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnCriarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRenomearPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluirPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFavoritosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(panelFavoritosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoverVideo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        panelFavoritosLayout.setVerticalGroup(
            panelFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFavoritosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPerfilTitulo1)
                .addGap(18, 18, 18)
                .addGroup(panelFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(panelFavoritosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCriarPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRenomearPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirPlaylist, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRemoverVideo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lista de Reprodução", panelFavoritos);

        panelPerfil.setBackground(new java.awt.Color(51, 51, 51));

        lblPerfilTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lblPerfilTitulo.setForeground(new java.awt.Color(204, 0, 0));
        lblPerfilTitulo.setText("Meu Perfil");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome:");

        lblEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("E-mail:");

        lblTotalUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalUsuarios.setText("Total de usuarios:");

        lblTotalVideos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotalVideos.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalVideos.setText("Total de videos:");

        javax.swing.GroupLayout panelPerfilLayout = new javax.swing.GroupLayout(panelPerfil);
        panelPerfil.setLayout(panelPerfilLayout);
        panelPerfilLayout.setHorizontalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPerfilLayout.createSequentialGroup()
                .addContainerGap(407, Short.MAX_VALUE)
                .addComponent(lblPerfilTitulo)
                .addGap(203, 203, 203))
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalUsuarios)
                    .addComponent(lblTotalVideos)
                    .addComponent(lblEmail)
                    .addComponent(lblNome))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPerfilLayout.setVerticalGroup(
            panelPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPerfilLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblPerfilTitulo)
                .addGap(57, 57, 57)
                .addComponent(lblNome)
                .addGap(41, 41, 41)
                .addComponent(lblEmail)
                .addGap(41, 41, 41)
                .addComponent(lblTotalUsuarios)
                .addGap(54, 54, 54)
                .addComponent(lblTotalVideos)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Perfil", panelPerfil);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // </editor-fold>

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        carregarVideos(txtBusca.getText());
    }

    private void lstVideosValueChanged(javax.swing.event.ListSelectionEvent evt) {
        if (evt.getValueIsAdjusting()) return;
        SerieFilme video = (SerieFilme) lstVideos.getSelectedValue();
        if (video != null) {
            txtDetalhes.setText(
                "Titulo: " + video.getTitulo() + "\n" +
                "Tipo: " + video.getTipo() + "\n" +
                "Ano: " + video.getAno() + "\n" +
                "Categoria: " + video.getCategoria() + "\n" +
                "Detalhe: " + video.getDetalhe() + "\n" +
                "Likes: " + video.getLikes() + "\n" +
                "Dislikes: " + video.getDislikes() + "\n\n" +
                "Descricao:\n" + video.getDescricao()
            );
        }
    }

    private void btnCurtirActionPerformed(java.awt.event.ActionEvent evt) {
        SerieFilme video = (SerieFilme) lstVideos.getSelectedValue();
        if (video == null) return;
        videoController.curtir(usuario.getId(), video.getId());
        carregarVideos(txtBusca.getText());
    }

    private void btnDescurtirActionPerformed(java.awt.event.ActionEvent evt) {
        SerieFilme video = (SerieFilme) lstVideos.getSelectedValue();
        if (video == null) return;
        videoController.descurtir(usuario.getId(), video.getId());
        carregarVideos(txtBusca.getText());
    }

    private void btnAdicionarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {
        SerieFilme video = (SerieFilme) lstVideos.getSelectedValue();
        ListaReproducao lista = (ListaReproducao) cmbPlaylists.getSelectedItem();
        if (video == null || lista == null) return;
        listaController.adicionarVideo(lista.getId(), video.getId());
        carregarVideosDaPlaylist();
    }

    private void lstPlaylistsValueChanged(javax.swing.event.ListSelectionEvent evt) {
        if (!evt.getValueIsAdjusting()) carregarVideosDaPlaylist();
    }

    private void btnCriarPlaylistActionPerformed(java.awt.event.ActionEvent evt) {
        String nome = javax.swing.JOptionPane.showInputDialog(this, "Nome da playlist:");
        if (nome == null) return;
        listaController.criar(usuario.getId(), nome);
        carregarPlaylists();
    }

    private void btnRenomearPlaylistActionPerformed(java.awt.event.ActionEvent evt) {
        ListaReproducao lista = (ListaReproducao) lstPlaylists.getSelectedValue();
        if (lista == null) return;
        String novoNome = javax.swing.JOptionPane.showInputDialog(this, "Novo nome:", lista.getNome());
        if (novoNome == null) return;
        listaController.renomear(lista.getId(), novoNome);
        carregarPlaylists();
    }

    private void btnExcluirPlaylistActionPerformed(java.awt.event.ActionEvent evt) {
        ListaReproducao lista = (ListaReproducao) lstPlaylists.getSelectedValue();
        if (lista == null) return;
        listaController.excluir(lista.getId());
        carregarPlaylists();
        playlistVideosModel.clear();
    }

    private void btnRemoverVideoActionPerformed(java.awt.event.ActionEvent evt) {
        ListaReproducao lista = (ListaReproducao) lstPlaylists.getSelectedValue();
        SerieFilme video = (SerieFilme) lstVideosPlaylist.getSelectedValue();
        if (lista == null || video == null) return;
        listaController.removerVideo(lista.getId(), video.getId());
        carregarVideosDaPlaylist();
    }

    private void carregarVideos(String termo) {
        videosModel.clear();
        List<SerieFilme> videos = videoController.listar(termo);
        for (SerieFilme v : videos) videosModel.addElement(v);
        if (!videosModel.isEmpty()) lstVideos.setSelectedIndex(0);
        else txtDetalhes.setText("");
    }

    private void carregarPlaylists() {
        playlistsModel.clear();
        List<ListaReproducao> playlists = listaController.listarDoUsuario(usuario.getId());
        DefaultComboBoxModel<ListaReproducao> comboModel = new DefaultComboBoxModel<>();
        for (ListaReproducao l : playlists) {
            playlistsModel.addElement(l);
            comboModel.addElement(l);
        }
        cmbPlaylists.setModel(comboModel);
        if (!playlistsModel.isEmpty()) lstPlaylists.setSelectedIndex(0);
    }

    private void carregarVideosDaPlaylist() {
        playlistVideosModel.clear();
        ListaReproducao lista = (ListaReproducao) lstPlaylists.getSelectedValue();
        if (lista == null) return;
        List<SerieFilme> videos = listaController.listarVideos(lista.getId());
        for (SerieFilme v : videos) playlistVideosModel.addElement(v);
    }

    private void atualizarPerfil() {
        setTitle("FEItv - " + usuario.getNome());
        lblNome.setText("Nome: " + usuario.getNome());
        lblEmail.setText("E-mail: " + usuario.getEmail());
        lblTotalUsuarios.setText("Total de usuarios: " + usuarioController.totalUsuarios());
        lblTotalVideos.setText("Total de videos: " + videoController.totalVideos());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarPlaylist;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCriarPlaylist;
    private javax.swing.JButton btnCurtir;
    private javax.swing.JButton btnDescurtir;
    private javax.swing.JButton btnExcluirPlaylist;
    private javax.swing.JButton btnRemoverVideo;
    private javax.swing.JButton btnRenomearPlaylist;
    private javax.swing.JComboBox cmbPlaylists;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPerfilTitulo;
    private javax.swing.JLabel lblPerfilTitulo1;
    private javax.swing.JLabel lblPerfilTitulo2;
    private javax.swing.JLabel lblPlaylist;
    private javax.swing.JLabel lblTotalUsuarios;
    private javax.swing.JLabel lblTotalVideos;
    private javax.swing.JList lstPlaylists;
    private javax.swing.JList lstVideos;
    private javax.swing.JList lstVideosPlaylist;
    private javax.swing.JPanel panelBusca;
    private javax.swing.JPanel panelFavoritos;
    private javax.swing.JPanel panelPerfil;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextArea txtDetalhes;
    // End of variables declaration//GEN-END:variables

    /**
     * Inicia a aplicação.
     * @param args argumentos da aplicação
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaPrincipal tela = new TelaPrincipal();
                tela.setDados(new Usuario(0, "Cliente", "cliente@teste.com", ""),
                        new UsuarioController(), new VideoController(), new ListaController());
                tela.setVisible(true);
            }
        });
    }

}
