# Desafio Copa 2014

Desafio Copa 2014 proposto pelo Plínio Balduino (pbalduino):

"Dada uma lista de placares da Copa do Mundo, retornar uma tabela contendo:
Nome da seleção, Quantidade de Jogos, Vitórias, Empates, Derrotas, Gols Pro, Gols Contra e Saldo de Gols.

A tabela deve estar ordenada por:

Pontuação (vitorias * 3 + empates), saldo de gols, gols pro e confronto direto, se for o caso.

A lista: https://gist.github.com/pbalduino/aa9ffaed4f7a13da2fb8"


## Usage
lein repl
> (use 'copa2014.core)
> (statistics matches)


Output:

| :team | :win | :draw | :los | :goals | :points |
|-------+------+-------+------+--------+---------|
|  :hol |    3 |     0 |    0 |     10 |       9 |
|  :col |    3 |     0 |    0 |      9 |       9 |
|  :arg |    3 |     0 |    0 |      6 |       9 |
|  :bel |    3 |     0 |    0 |      4 |       9 |
|  :bra |    2 |     1 |    0 |      7 |       7 |
|  :ale |    2 |     1 |    0 |      7 |       7 |
|  :cos |    2 |     1 |    0 |      4 |       7 |
|  :sui |    2 |     0 |    1 |      7 |       6 |
|  :chi |    2 |     0 |    1 |      5 |       6 |
|  :uru |    2 |     0 |    1 |      4 |       6 |
|  :mex |    2 |     1 |    0 |      4 |       4 |
|  :fra |    2 |     1 |    0 |      8 |       1 |
|  :agl |    1 |     1 |    1 |      6 |       4 |
|  :eua |    1 |     1 |    1 |      4 |       4 |
|  :por |    1 |     1 |    1 |      4 |       4 |
|  :nga |    1 |     1 |    1 |      3 |       4 |
|  :equ |    1 |     1 |    1 |      3 |       4 |
|  :gre |    1 |     1 |    1 |      2 |       4 |
|  :cro |    1 |     0 |    2 |      6 |       3 |
|  :bos |    1 |     0 |    2 |      4 |       3 |
|  :esp |    1 |     0 |    2 |      4 |       3 |
|  :cdm |    1 |     0 |    2 |      4 |       3 |
|  :ita |    1 |     0 |    2 |      2 |       3 |
|  :rus |    0 |     2 |    1 |      2 |       2 |
|  :gan |    0 |     1 |    2 |      4 |       1 |
|  :cor |    0 |     1 |    2 |      3 |       1 |
|  :jap |    0 |     1 |    2 |      2 |       1 |
|  :ing |    0 |     1 |    2 |      2 |       1 |
|  :ira |    0 |     1 |    2 |      1 |       1 |
|  :aus |    0 |     0 |    3 |      3 |       0 |
|  :cam |    0 |     0 |    3 |      1 |       0 |
|  :hon |    0 |     0 |    3 |      1 |       0 |