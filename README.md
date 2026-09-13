# 🎲 Gerador de Multiplicação

Aplicação desktop desenvolvida em **Java** utilizando **Java Swing**, criada com o objetivo de gerar multiplicações aleatórias de acordo com um intervalo definido pelo usuário.

O projeto também possui histórico das multiplicações sorteadas, visualização do resultado e uma tela de configurações.

---

## 📌 Funcionalidades

- 🎲 **Sortear multiplicação**
  - Gera dois números aleatórios dentro do intervalo configurado.
  - Exibe a multiplicação na tela.
  - Armazena cada multiplicação no histórico.

- 🧮 **Visualizar resultado**
  - Exibe o resultado da última multiplicação sorteada.

- 📜 **Histórico**
  - Armazena as multiplicações realizadas.
  - Exibe até 10 multiplicações por página.
  - Possui navegação entre páginas.
  - Permite limpar o histórico.

- ⚙️ **Configurações**
  - Permite definir o número mínimo.
  - Permite definir o número máximo.
  - Valida os valores informados antes de salvar.

- ❌ **Sair**
  - Fecha a aplicação.

---

## 🖥️ Interface

A aplicação possui uma janela principal com:

- Título do programa;
- Área para exibição da multiplicação;
- Botão **Sortear**;
- Botão **Histórico**;
- Botão **Resultado**;
- Botão **Configurações**;
- Botão **Sair**.

---

## ⚙️ Configurações

Por padrão, o programa utiliza:

```text
Número mínimo: 0
Número máximo: 10
```

Esses valores podem ser alterados através da tela **Configurações**.

O usuário deve informar números inteiros e o valor mínimo não pode ser maior ou igual ao valor máximo.

---

## 📜 Histórico

Cada multiplicação sorteada é adicionada ao histórico.

Exemplo:

```text
2 x 7
10 x 4
5 x 8
0 x 6
3 x 9
```

O histórico é dividido em páginas com **10 itens por página**.

É possível:

- Voltar para a página anterior;
- Avançar para a próxima página;
- Limpar todo o histórico.

---

## 🛠️ Tecnologias utilizadas

- **Java**
- **Java Swing**
- `ArrayList`
- `Random`
- `JFrame`
- `JButton`
- `JLabel`
- `JTextField`
- `JTextArea`
- `JScrollPane`
- `JOptionPane`
- `AtomicInteger`
- `AtomicBoolean`

---

## 📂 Estrutura

Atualmente, o projeto possui uma classe principal:

```text
Random2a10
└── Random2a10.java
```

A classe contém o método:

```java
public static void main(String[] args)
```

que inicia a aplicação.

---

## ▶️ Como executar

### 1. Pré-requisitos

É necessário ter o **Java JDK** instalado.

Verifique a instalação utilizando:

```bash
java -version
```

e:

```bash
javac -version
```

### 2. Executar pela IDE

Abra o projeto em uma IDE compatível com Java, como:

- IntelliJ IDEA
- Eclipse
- Visual Studio Code

Execute a classe:

```text
Random2a10.java
```

---

## 🧮 Funcionamento

Ao clicar em **Sortear**, o programa gera dois números aleatórios utilizando o intervalo configurado:

```java
int numero1 = r.nextInt((max.get() - min.get()) + 1) + min.get();
int numero2 = r.nextInt((max.get() - min.get()) + 1) + min.get();
```

Depois, calcula o resultado:

```java
resultMult[0] = numero1 * numero2;
```

A multiplicação também é adicionada ao histórico:

```java
historico.add(multiplicacao);
```

---

## 🎯 Objetivo do projeto

O projeto foi desenvolvido como uma aplicação prática para exercitar conceitos fundamentais de Java, como:

- Variáveis;
- Estruturas condicionais;
- Tratamento de exceções;
- Listas;
- Geração de números aleatórios;
- Programação orientada a eventos;
- Interfaces gráficas;
- Manipulação de componentes Swing;
- Expressões lambda;
- Organização de informações em memória.

---

## 🚀 Possíveis melhorias futuras

Algumas funcionalidades que podem ser adicionadas futuramente:

- [ ] Salvar o histórico em arquivo;
- [ ] Carregar o histórico ao iniciar o programa;
- [ ] Permitir escolher diferentes operações matemáticas;
- [ ] Adicionar divisão, soma e subtração;
- [ ] Criar sistema de pontuação;
- [ ] Adicionar contador de acertos e erros;
- [ ] Melhorar o design da interface;
- [ ] Separar o projeto em diferentes classes;
- [ ] Criar um instalador para Windows;


---

## 👨‍💻 Autor

**Diogo Donner**

Projeto desenvolvido para fins de estudo e prática de programação em Java.
