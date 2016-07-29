package view;

import controller.UsuarioController;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class UsuarioEditarGui extends JPanel {
     private JLabel lbNome, lbLogin ;
    private JTextField tfNome, tfLogin;
    
    private JButton btEditar, btLimpar;
    
    public UsuarioEditarGui() {
        loadComponents();
        setEvents();
    }

    private void loadComponents() {
        setLayout(null);
        lbNome = new JLabel("Novo Nome:");
        lbLogin = new JLabel("Login:");
     
        tfNome = new JTextField();
        tfLogin = new JTextField();
      
       
        btEditar = new JButton("Editar");
        btLimpar = new JButton("Limpar");
        
        lbLogin.setBounds(30, 30, 80, 25);
        tfLogin.setBounds(100, 30, 200, 25);
        lbNome.setBounds(30, 75, 80, 25);
        tfNome.setBounds(100, 75, 200, 25);
    
       
        btEditar.setBounds(30, 210, 100, 25);
        btLimpar.setBounds(135, 210, 100, 25);
        
        
        add(lbNome);
        add(tfNome);
        add(lbLogin);
        add(tfLogin);
       
        add(btEditar);
        add(btLimpar);
    }

    private void setEvents() {
        btLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpar();
            }
        });
        btEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioController controller = new UsuarioController();
               if (controller.editar(tfLogin.getText(), tfNome.getText())){
                    JOptionPane.showMessageDialog(null, "Usuario editado com sucesso!");
                  limpar();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao editar!");
                }
                
            }
        });
    }
    
    private void limpar() {
        tfNome.setText("");
        tfLogin.setText("");
   
       
        tfNome.requestFocus();
    }
    
}
