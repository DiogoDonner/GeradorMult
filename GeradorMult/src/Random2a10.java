
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Random2a10 {

    public static void main(String[] args) {

        Random r = new Random();

        AtomicBoolean rodando = new AtomicBoolean(true);

        int min = 2;
        int max = 10;
        int itensPorPagina = 10;
        ArrayList<String> historico = new ArrayList<>();
        int[] resultMult = {0};

        JFrame janela = new JFrame();

        janela.setSize(600, 300);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);


        janela.setLayout(new BorderLayout());


        JLabel titulo = new JLabel("GERADOR DE MULTIPLICAÇÃO");
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        JLabel resultado = new JLabel("Clique em Sortear", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 32));


        JButton botaoSortear = new JButton("Sortear");
        botaoSortear.setFont(new Font("Arial", Font.BOLD, 16));


        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Arial", Font.BOLD, 16));

        JButton botaoHistorico = new JButton("Histórico");
        botaoHistorico.setFont(new Font("Arial", Font.BOLD, 16));

        JButton botaoResultado = new JButton("Resultado");
        botaoResultado.setFont(new Font("Arial", Font.BOLD, 16));


        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoSortear);
        painelBotoes.add(botaoSair);
        painelBotoes.add(botaoHistorico);
        painelBotoes.add(botaoResultado);


        botaoSortear.addActionListener(e -> {
            int numero1 = r.nextInt((max - min) + 1) + min;
            int numero2 = r.nextInt((max - min) + 1) + min;
            resultMult[0] = numero1 * numero2;
            String multiplicacao = numero1 + " x " + numero2;
            historico.add(multiplicacao);
            resultado.setText(multiplicacao);
        });


        botaoResultado.addActionListener(e -> {
            if (resultMult[0] == 0) {
                JOptionPane.showMessageDialog(
                        janela,
                        "Nenhuma multiplicação foi sorteada ainda.",
                        "RESULTADO",
                        JOptionPane.INFORMATION_MESSAGE);
                return;

            } else {
                JOptionPane.showMessageDialog(
                        janela,
                        "<html>O Resultado da Multiplicação é: <u>" + resultMult[0] + "</u></html>",
                        "RESULTADO",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }
        });


        botaoSair.addActionListener(e -> {

            rodando.set(false);

            janela.dispose();
        });

        botaoHistorico.addActionListener(e -> {

            if (historico.isEmpty()) {
                JOptionPane.showMessageDialog(
                        janela,
                        "Nenhuma multiplicação foi sorteada ainda.",
                        "Histórico",
                        JOptionPane.INFORMATION_MESSAGE
                );
                return;
            }

            JFrame janelaHistorico = new JFrame("Histórico de Multiplicações");
            janelaHistorico.setSize(450, 400);
            janelaHistorico.setLocationRelativeTo(janela);
            janelaHistorico.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            JTextArea listaHistorico = new JTextArea();
            listaHistorico.setFont(new Font("Arial", Font.PLAIN, 18));
            listaHistorico.setEditable(false);

            JScrollPane scroll = new JScrollPane(listaHistorico);


            final int[] paginaAtual = {0};

            JLabel paginaLabel = new JLabel();
            paginaLabel.setHorizontalAlignment(SwingConstants.CENTER);
            paginaLabel.setFont(new Font("Arial", Font.BOLD, 16));

            JButton botaoAnterior = new JButton("← Anterior");
            JButton botaoProxima = new JButton("Próxima →");
            JButton botaoLimpar = new JButton("Limpar histórico");


            Runnable atualizarPagina = () -> {

                listaHistorico.setText("");

                int totalPaginas = (int) Math.ceil(
                        (double) historico.size() / itensPorPagina
                );

                int inicio = paginaAtual[0] * itensPorPagina;
                int fim = Math.min(
                        inicio + itensPorPagina,
                        historico.size()
                );

                for (int i = inicio; i < fim; i++) {

                    listaHistorico.append(
                            historico.get(i) + "\n"
                    );
                }

                paginaLabel.setText(
                        "Página " + (paginaAtual[0] + 1) +
                                " / " + totalPaginas
                );

                botaoAnterior.setEnabled(paginaAtual[0] > 0);
                botaoProxima.setEnabled(
                        paginaAtual[0] < totalPaginas - 1
                );
            };


            botaoAnterior.addActionListener(e2 -> {

                if (paginaAtual[0] > 0) {
                    paginaAtual[0]--;
                    atualizarPagina.run();
                }
            });

            botaoProxima.addActionListener(e2 -> {

                int totalPaginas = (int) Math.ceil(
                        (double) historico.size() / itensPorPagina
                );

                if (paginaAtual[0] < totalPaginas - 1) {
                    paginaAtual[0]++;
                    atualizarPagina.run();
                }
            });


            botaoLimpar.addActionListener(e2 -> {

                int resposta = JOptionPane.showConfirmDialog(
                        janelaHistorico,
                        "Deseja realmente limpar o histórico?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION
                );

                if (resposta == JOptionPane.YES_OPTION) {

                    historico.clear();
                    janelaHistorico.dispose();
                }
            });

            JPanel painelBotoesHistorico = new JPanel();

            painelBotoesHistorico.add(botaoAnterior);
            painelBotoesHistorico.add(paginaLabel);
            painelBotoesHistorico.add(botaoProxima);

            JPanel painelInferior = new JPanel(new BorderLayout());

            painelInferior.add(
                    painelBotoesHistorico,
                    BorderLayout.CENTER
            );

            painelInferior.add(
                    botaoLimpar,
                    BorderLayout.SOUTH
            );

            janelaHistorico.setLayout(new BorderLayout());

            janelaHistorico.add(
                    scroll,
                    BorderLayout.CENTER
            );

            janelaHistorico.add(
                    painelInferior,
                    BorderLayout.SOUTH
            );

            atualizarPagina.run();

            janelaHistorico.setVisible(true);
        });


        janela.add(titulo, BorderLayout.NORTH);
        janela.add(resultado, BorderLayout.CENTER);
        janela.add(painelBotoes, BorderLayout.SOUTH);


        janela.setVisible(true);
    }
}


