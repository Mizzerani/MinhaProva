import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


public class BBB extends JFrame{

    private JPanel painel = new JPanel();
    private JButton jButtonVotacao = new JButton("Votar");
    private JButton jButtonApuracao = new JButton("Apurar resultado");


    public BBB(){
        this.setTitle("** Eliminação BBB **");
        this.setSize(400,420);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255, 255, 255));

        ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("Isabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Matteus Amaral"));
        jogadores.add(new Jogador("Maycon Cosmer"));
        jogadores.add(new Jogador("MC Bin Laden"));
        jogadores.add(new Jogador("Michel Nogueira"));
        jogadores.add(new Jogador("Raquele Cardozo"));
        jogadores.add(new Jogador("Rodriguinho"));
        jogadores.add(new Jogador("Thalyta Alves"));
        jogadores.add(new Jogador("Vanessa Lopes"));
        jogadores.add(new Jogador("Vinicius Rodrigues"));
        jogadores.add(new Jogador("Wanessa Camargo"));
        jogadores.add(new Jogador("Yasmin Brunet"));

        jButtonVotacao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                votacao(jogadores);
            }
        });

        jButtonApuracao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                apuracao(jogadores);
            }
        });

        jButtonVotacao.setPreferredSize(new Dimension(150, 100));
        jButtonApuracao.setPreferredSize(new Dimension(150, 100));

        painel.add(jButtonVotacao);
        painel.add(jButtonApuracao);

        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void votacao(ArrayList<Jogador> jogadores) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            JOptionPane.showInputDialog(null, "Digite o nome do jogador em quem deseja votar ou digite sair para finalizar a votação.");
            String nome = scanner.nextLine();
            if (nome.equalsIgnoreCase("sair")) {
                break;
            } else {
                for (Jogador jogador : jogadores) {
                    if (jogador.getNome().equalsIgnoreCase(nome)) {
                        jogador.incrementaUmVoto();
                        break;
                    }
                }
            }
            JOptionPane.showMessageDialog(null, "Voto computado com sucesso!");
        }
    }

    private void apuracao(ArrayList<Jogador> jogadores) {
        Jogador jogadorMaisVotado = jogadores.get(0);
        for (Jogador jogador : jogadores) {
            if (jogador.getVotos() > jogadorMaisVotado.getVotos()) {
                jogadorMaisVotado = jogador;
            }
        }
        JOptionPane.showMessageDialog(null, "Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir " +
                "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu " +
                "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu " +
                "vou conseguir te eliminar com alegria. Com " + jogadorMaisVotado.getVotos() + " votos, é você quem sai " +
                jogadorMaisVotado.getNome() + ".");
    }

    public static void main(String[] args) {
        new BBB();
    }
}
