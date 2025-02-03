import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JRevista {
    public JRevista(ArrayList<Publicacao> publicacoes){
        JFrame revista = new JFrame("Cadastro de Revistas");
        revista.setSize(470, 250);
        revista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        revista.setResizable(false); //tamanho da tela é fixo
        revista.getContentPane().setBackground(new Color(250, 250, 250));


        //criando labels presentes no frame:
        JLabel lRevistas = new JLabel("Revistas");
        JLabel lTitulo = new JLabel("Título: ");
        JLabel lOrg = new JLabel("Org.: ");
        JLabel lNum = new JLabel("Nro.: ");
        JLabel lVol = new JLabel("Vol.: ");
        JLabel lAno = new JLabel("Ano: ");

        //criando text fields presentes no frame:
        JTextField tTitulo = new JTextField(30);
        JTextField tOrg = new JTextField(30);
        JTextField tNum = new JTextField(3);
        JTextField tVol = new JTextField(3);
        JTextField tAno = new JTextField(3);

        //criando botões presentes no frame:
        JButton incluir = new JButton("Incluir");
        JButton livros = new JButton("Livros");
        JButton listagem = new JButton("Listagem");

        //criando containers principais do frame:
        //layout = grid
        revista.setLayout(new GridLayout(5, 1));

        //criando 5 containers:
        JPanel um = new JPanel();
        JPanel dois = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JPanel tres = new JPanel(new FlowLayout(FlowLayout.LEFT, 13, 5));
        JPanel quatro = new JPanel(new FlowLayout(FlowLayout.LEFT, 13, 5));
        JPanel cinco = new JPanel();

        //adicionando bordas para melhorar o espaçamento geral
        dois.setBorder(new EmptyBorder(5, 10, 5, 10));
        tres.setBorder(new EmptyBorder(5, 10, 5, 10));
        quatro.setBorder(new EmptyBorder(5, 10, 5, 10));

        //adicionando componentes nos containers criados:
        um.add(lRevistas);
        dois.add(lTitulo);
        dois.add(tTitulo);
        tres.add(lOrg);
        tres.add(tOrg);
        quatro.add(lVol);
        quatro.add(tVol);
        quatro.add(lNum);
        quatro.add(tNum);
        quatro.add(lAno);
        quatro.add(tAno);
        cinco.add(incluir);
        cinco.add(livros);
        cinco.add(listagem);

        revista.add(um);
        revista.add(dois);
        revista.add(tres);
        revista.add(quatro);
        revista.add(cinco);

        incluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = tTitulo.getText();
                String org = tOrg.getText();
                String nro = tNum.getText();
                String vol = tVol.getText();
                String ano = tAno.getText();

                if (t.isEmpty() || org.isEmpty() || ano.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Algum campo está vazio. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Verificando se ano é um número valido:
                    try {
                        int nroInt = Integer.parseInt(nro);
                        int volInt = Integer.parseInt(vol);
                        int anoInt = Integer.parseInt(ano); // se essa linha der errado, a exceção numberFormatException será jogada
                        if (anoInt < 0 || volInt <= 0 || nroInt <= 0) {
                            JOptionPane.showMessageDialog(null, "Formato inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            publicacoes.add(new Revista(t, anoInt, org, volInt, nroInt));
                            tTitulo.setText("");
                            tAno.setText("");
                            tOrg.setText("");
                            tVol.setText("");
                            tNum.setText("");
                            JOptionPane.showMessageDialog(null, "Cadastro realizado :)", "Boa!", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Formato inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                    }
                }


            }
        });


        livros.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revista.dispose();
                new JRevista(publicacoes);
            }
        });

        listagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                revista.dispose();
                new JListagem(publicacoes);
            }
        });

        revista.setVisible(true);
    }
}