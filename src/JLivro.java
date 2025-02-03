import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JLivro {
    public JLivro(ArrayList<Publicacao> publicacoes) {

        //criando um novo frame para cadastrar livros
        JFrame livros = new JFrame("Cadastro de Livros");
        livros.setSize(470, 250);
        livros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        livros.setResizable(false); //tamanho da tela é fixo
        livros.getContentPane().setBackground(new Color(250, 250, 250));

        //criando labels presentes no frame:
        JLabel lLivros = new JLabel("Livros");
        JLabel lTitulo = new JLabel("Título: ");
        JLabel lAutor = new JLabel("Autor: ");
        JLabel lAno = new JLabel("Ano: ");

        //criando text fields presentes no frame:
        JTextField tTitulo = new JTextField(30);
        JTextField tAutor = new JTextField(30);
        JTextField tAno = new JTextField(3);

        //criando botões presentes no frame:
        JButton incluir = new JButton("Incluir");
        JButton revistas = new JButton("Revistas");
        JButton listagem = new JButton("Listagem");

        //criando containers principais do frame:
        //layout = grid
        livros.setLayout(new GridLayout(5, 1));

        //criando 5 containers:
        JPanel um = new JPanel();
        JPanel dois = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JPanel tres = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JPanel quatro = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        JPanel cinco = new JPanel();

        //adicionando bordas para melhorar o espaçamento geral
        dois.setBorder(new EmptyBorder(5, 10, 5, 10));
        tres.setBorder(new EmptyBorder(5, 10, 5, 10));
        quatro.setBorder(new EmptyBorder(5, 10, 5, 10));

        //adicionando componentes nos containers criados:
        um.add(lLivros);
        dois.add(lTitulo);
        dois.add(tTitulo);
        tres.add(lAutor);
        tres.add(tAutor);
        quatro.add(lAno);
        quatro.add(tAno);
        cinco.add(incluir);
        cinco.add(revistas);
        cinco.add(listagem);


        livros.add(um);
        livros.add(dois);
        livros.add(tres);
        livros.add(quatro);
        livros.add(cinco);

        //implementado action listener nos botoes criados:

        //cadastrando o livro:
        incluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String t = tTitulo.getText();
                String autor = tAutor.getText();
                String ano = tAno.getText();

                if (t.isEmpty() || autor.isEmpty() || ano.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Algum campo está vazio. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                } else {
                    //Verificando se ano é um número valido:
                    try {
                        int anoInt = Integer.parseInt(ano); // se essa linha der errado, a exceção numberFormatException será jogada
                        if (anoInt < 0) {
                            JOptionPane.showMessageDialog(null, "Ano inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                            return;
                        } else {
                            publicacoes.add(new Livro(t, anoInt, autor));
                            tTitulo.setText("");
                            tAno.setText("");
                            tAutor.setText("");
                            JOptionPane.showMessageDialog(null, "Cadastro realizado :)", "Boa!", JOptionPane.INFORMATION_MESSAGE);
                        }

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ano inválido. Tente novamente.", "Erro :(", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        revistas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                livros.dispose();
                new JRevista(publicacoes);
            }
        });

        listagem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                livros.dispose();
                new JListagem(publicacoes);
            }
        });

        livros.setVisible(true);
    }
}