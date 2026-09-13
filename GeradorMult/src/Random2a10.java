
import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Random2a10{

    public static void main(String[] args) {

        Random r = new Random();

        AtomicBoolean rodando = new AtomicBoolean(true);

        int min = 2;
        int max = 10;

        JFrame janela = new JFrame("Random 2 a 10");

        janela.setSize(450, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);


        janela.setLayout(new BorderLayout());


        JLabel titulo = new JLabel("GERADOR DE MULTIPLICAÇÃO");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel resultado = new JLabel("Clique em Sortear", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 32));


        JButton botaoSortear = new JButton("Sortear novamente");
        botaoSortear.setFont(new Font("Arial", Font.BOLD, 16));


        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Arial", Font.BOLD, 16));


        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoSortear);
        painelBotoes.add(botaoSair);


        botaoSortear.addActionListener(e -> {

            int numero1 = r.nextInt((max - min) + 1) + min;
            int numero2 = r.nextInt((max - min) + 1) + min;

            resultado.setText(numero1 + " x " + numero2);
        });


        botaoSair.addActionListener(e -> {

            rodando.set(false);

            janela.dispose();
        });


        janela.add(titulo, BorderLayout.NORTH);
        janela.add(resultado, BorderLayout.CENTER);
        janela.add(painelBotoes, BorderLayout.SOUTH);


        janela.setVisible(true);
    }
}


