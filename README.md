# academic-system

## Descrição

Projeto: Sistema de Controle Acadêmico

Este repositório implementa um sistema simples para gerenciar cursos, alunos, professores e notas. O objetivo é atender às regras mínimas do trabalho: organizar o projeto em pacotes, aplicar encapsulamento (getters/setters), implementar ações/relacionamentos entre classes e adicionar comentários explicativos.

## Regras mínimas obrigatórias (trecho do enunciado)

19. O sistema deve conter no mínimo 4 classes criadas pelo aluno.

20. Cada classe deve possuir pelo menos 3 atributos privados.

21. Todos os atributos devem ser acessados por meio de métodos getters e setters.

22. Cada classe deve ter pelo menos um método que represente uma ação ou comportamento (por exemplo, adicionar, remover, calcular, verificar etc.).

23. Deve existir relacionamento entre as classes, ou seja, uma classe deve utilizar objetos de outras.

24. O projeto deve estar organizado em pacotes, como model, service, app (ou outros que o aluno julgar adequados).

25. Nenhuma classe, exceto a Main, deve conter instruções de saída (System.out.println).

26. A classe principal (Main) deve conter um programa de simulação, demonstrando as principais operações e interações do sistema.

27. O código deve ser comentado, explicando o papel de cada classe, atributo e método.

## Orientações (resumo)

- O aluno é livre para definir quais entidades farão parte do sistema e como elas se relacionam.
- É importante pensar no fluxo de funcionamento (ex.: matrícula, atribuição de notas, cálculo de status).
- Foco em organização, abstração, encapsulamento e interação entre objetos.
- Serão valorizados modelos coerentes, criatividade e código bem estruturado.

## Tema: Sistema de Controle Acadêmico

Desenvolver um sistema que permita gerenciar cursos, alunos, professores e notas. Implemente as operações principais (matrícula, adicionar disciplina, vincular professor, atribuir nota, calcular status no histórico acadêmico, etc.) e comente o código explicando responsabilidades.

## Estrutura sugerida

- `src/model` — classes de domínio (Aluno, Professor, Curso, Disciplina, HistoricoAcademico...)
- `src/service` — classes que implementam regras e operações (AcademicManager, etc.)
- `src/app` — classe `Main`/simulação

## Template (cabecalhos do trabalho)

Turma: **\_\_\_\_**

RA / Nome: ******\*\*******\_\_\_******\*\*******

RA / Nome: ******\*\*******\_\_\_******\*\*******

RA / Nome: ******\*\*******\_\_\_******\*\*******

RA / Nome: ******\*\*******\_\_\_******\*\*******

RA / Nome: ******\*\*******\_\_\_******\*\*******

## Como compilar / executar (exemplo)

Recomendo usar uma IDE (IntelliJ, Eclipse, VS Code com extensão Java). Se preferir linha de comando (PowerShell), compile todas as classes e execute a classe que contém o método `main` substituindo `MainClass` pelo nome correto:

```powershell
# criar pasta de saída
mkdir out -Force

# compilar (pode ser necessário ajustar o padrão dependendo da sua versão do shell)
javac -d out (Get-ChildItem -Path src -Recurse -Filter *.java | ForEach-Object -ExpandProperty FullName)

# executar (substitua MainClass pelo nome fully-qualified da classe principal, ex: app.Main)
java -cp out MainClass
```

Se tiver dúvidas sobre o comando `javac` no PowerShell, prefira compilar com sua IDE.

## Observações finais

Copie as descrições das ações e relacionamentos para os comentários das classes correspondentes (por exemplo: `Course`, `Teacher`, `Student`, `AcademicTranscript`, `Subject`). Testes e comentários adicionais serão valorizados.
