package view;

import controller.UsuarioController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UsuarioExcluirGui extends JPanel{

     private JLabel lbLogin ;
    private JTextField tfLogin;
    
    private JButton btExcluir, btLimpar;
    
    public UsuarioExcluirGui() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        
        lbLogin = new JLabel("Login:");
     
        
        tfLogin = new JTextField();
      
       
        btExcluir = new JButton("Excluir");
        btLimpar = new JButton("Limpar");
        
        lbLogin.setBounds(30, 30, 80, 25);
        tfLogin.setBounds(100, 30, 200, 25);
        btExcluir.setBounds(30, 210, 100, 25);
        btLimpar.setBounds(135, 210, 100, 25);
        
        
        
        add(lbLogin);
        add(tfLogin);
       
        add(btExcluir);
        add(btLimpar);
    }

    private void setEvents() {
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
        btExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController controller = new UsuarioController();
               if (controller.exclir(tfLogin.getText())){
                    JOptionPane.showMessageDialog(null, "Usuario excluido com sucesso!");
                  limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao excluir!");
                }
                
            }
        });
    }
    
    private void limpar() {
        
        tfLogin.setText("");
   
       
        tfLogin.requestFocus();
    }
    
}


