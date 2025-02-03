import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class JListagem {
    public JListagem(ArrayList<Publicacao> publicacoes) {

        //frame para listagem
        JFrame listagem = new JFrame("Listagem de Publicações");
        listagem.setSize(470, 250);
        listagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //listagem.setResizable(false);
        listagem.getContentPane().setBackground(new Color(250, 250, 250));

        //painel principal com layout BorderLayout
        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 10));

        // label para o titulo
        JLabel titulo = new JLabel("Listagem");
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        titulo.setHorizontalAlignment(JLabel.CENTER);

        // criando um jtextarea para mostrar a lista
        JTextArea areaLista = new JTextArea(15, 30);
        areaLista.setEditable(false);
        //areaLista.setBackground(new Color(250, 250, 250)); // não funciona
        areaLista.setBorder(BorderFactory.createEmptyBorder());
        areaLista.setOpaque(true);

        /// criando uma barra de rolagem
        JScrollPane scrollPane = new JScrollPane(areaLista);

        // colocando margens no painel principal para melhor espaçamento
        painelPrincipal.setBorder(new EmptyBorder(10, 10, 10, 10));

        //usando o metodo toString para criar uma arraylist de strings
        ArrayList<String> detalhes = new ArrayList<>();
        for (Publicacao p : publicacoes) {
            detalhes.add(p.toString());
        }

        // juntando todas as strings salva na arraylist detalhes
        String textoFinal = String.join("\n", detalhes);

        // exibindo a o textofinal na textarea:
        areaLista.setText(textoFinal);
        areaLista.setFont(new Font("Arial", Font.PLAIN, 16));

        // adicionando componentes ao painel principal
        painelPrincipal.add(titulo, BorderLayout.NORTH);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // adicionando panel no frame
        listagem.add(painelPrincipal);

        // exibindo o frame
        listagem.setVisible(true);
    }
}
