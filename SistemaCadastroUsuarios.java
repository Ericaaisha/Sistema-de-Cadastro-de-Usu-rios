import java.util.ArrayList;
import java.util.Scanner;

public class SistemaCadastroUsuarios {

    // Classe interna para representar um Usuário
    static class Usuario {
        String nome;
        String email;
        int idade;

        public Usuario(String nome, String email, int idade) {
            this.nome = nome;
            this.email = email;
            this.idade = idade;
        }

        @Override
        public String toString() {
            return "Nome: " + nome + ", Email: " + email + ", Idade: " + idade;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> usuarios = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Sistema de Cadastro de Usuários ===");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Listar usuários");
            System.out.println("3. Editar usuário");
            System.out.println("4. Remover usuário");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    usuarios.add(new Usuario(nome, email, idade));
                    System.out.println("Usuário cadastrado com sucesso!");
                    break;
                case 2:
                    System.out.println("\n=== Lista de Usuários ===");
                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuário cadastrado.");
                    } else {
                        for (int i = 0; i < usuarios.size(); i++) {
                            System.out.println((i + 1) + ". " + usuarios.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Informe o número do usuário que deseja editar: ");
                    int editarIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir a quebra de linha
                    if (editarIndex >= 0 && editarIndex < usuarios.size()) {
                        System.out.print("Novo nome: ");
                        usuarios.get(editarIndex).nome = scanner.nextLine();
                        System.out.print("Novo email: ");
                        usuarios.get(editarIndex).email = scanner.nextLine();
                        System.out.print("Nova idade: ");
                        usuarios.get(editarIndex).idade = scanner.nextInt();
                        scanner.nextLine(); // Consumir a quebra de linha
                        System.out.println("Usuário editado com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Informe o número do usuário que deseja remover: ");
                    int removerIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consumir a quebra de linha
                    if (removerIndex >= 0 && removerIndex < usuarios.size()) {
                        usuarios.remove(removerIndex);
                        System.out.println("Usuário removido com sucesso!");
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}

