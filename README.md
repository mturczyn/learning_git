# branches_tests

Użyte komendy GIT w celu:
- stworzenia lokalnego repo
- podłączenia lokalnego repo pod repo zdalne (remote)
- utworzenia branchy na lokalnym repo
- push branchy na remote repo- praca z branchami

Lista komend:

Zmiana nazwy brancha:
```
git branch -m bracnh2 branch2
```
Wrzuca zmiany na repo zdalne (origin) na wskazanego brancha (branch2) i ustawia ten branch jako upstream, czyli tam gdzie bedziemu "pushować" i "pullować".
```
git push -u origin branch2
# alternatywna wersja
git push --set-upstream origin master
```
Listuje wszystkie branche.
```
git branch -a
```
Gdy utworzymy sobie lokalnie repo i je podłączymy do zdalnego repo, ich historie mogą być (i są :) ) "niepowiązane", wówczas przy próbie pulla albo pusha ze zdalnego repo będzie komunikat błędu mówiący o tym. Aby go ominąć musimy zrobić pulla z parametrem `--allow-unrelated-histories`:
```
git pull --allow-unrelated-histories origin master
```
Bez `-v` wyświetla listę zdalnych repo (czyli najczęściej `origin`), z argumentem `-v` wyświetla dodatkowo adresy URL repozytoriów.
```
git remote -v
```
Przełącza na branch master:
```
git checkout master
```
Tworzy brancha:
```
git checkout -b branch1
```
Ustawia adres zdalnego repo:
```
git remote add origin 'https://github.com/mturczyn/branches_tests'
```
Usuwa dany branch. Mozna podać argument `-d`, jednak on zawsze ostrzega o wykonanej pracy na branchu itp. `-D` natomiast wykonuje bez usuniecie brancha bez żadnych ostrzeżeń.
```
git branch -D branch1
```
Z argumentem `--index` ta komenda usunie pliki z indeksu (czyli takie, które zostały dodane za pomocą komendy `git add`, która dodaje pliki do indeksu).
```
git rm --cached .\project_file.txt
```
Inicjalizuje repozytorium git (tworzy ukryty folder .git z konfiguracją i inne potrzebne operacje):
```
git init
```

## git stash

Uzywany do odkładania zmian, bez dodawaania ich do indeksu. Czyli, mam pracę w trakcie (work in progress), nie chcę jeszcze jej dodawać do indeksu, ale muszę szybko przełączyć się na innego brancha, wówczas stashuje sobie zmiany, a obecny stan repo cofa mi się do tego, który jest na lokalnym repo. Wtedy mam czyste repo i mogę np. spokojnie sie przełączyć miedzy branchami.

## git commit --amend

Nadpisuje ostatni komit - użyteczne jeśli chcemy zmienić komentarz do komita. Uwaga: nie dotyczy komitów, które już poszły na zdalne repo.