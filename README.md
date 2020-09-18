# branches_tests

Początkowo miało być to repozytorium do nauki pracy z branchami na gicie, jednak w miarę pracy, przerodziło się w szerzej pojętą naukę GITa. Poniżej zbiór notatek z tego kursu.

Pliki z tego repozytorium są wyłącznie w celach testowych, nie stanowią żadnego projektu, ani aplikacji.

Źródła:
- [książka na stronie GIT](https://git-scm.com/book/en/v2/Getting-Started-Getting-Help)

## Nauka branchy

`git checkout` - przełącza na dany branch. Natomiast przełączanie na branch jest to przełączenie wskaźnika HEAD na ostatni commit, tzn. HEAD wskazuje na komit z danego brancha. Np.: jeśli mamy komity:
```
           master
		     ↓
c1 <- c2 <- c3 <- c4
                   ↑
				 branch
```
to przełączając się na brancha `branch` wskaźnik HEAD wskazuje na komit `c4`.

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
```
git stash
```
Uzywany do odkładania zmian, bez dodawania ich do indeksu. Czyli, mam pracę w trakcie (work in progress), nie chcę jeszcze jej dodawać do indeksu, ale muszę szybko przełączyć się na innego brancha, wówczas stashuje sobie zmiany, a obecny stan repo cofa mi się do tego, który jest na lokalnym repo. Wtedy mam czyste repo i mogę np. spokojnie sie przełączyć miedzy branchami.

Dodatkowo posiada argument `--index`, który przywraca odłożone zmiany, ale z indeksu (staged).

Można również odłożoną pracę odtworzyć jako nowy branch zamiast przywracać ją na akuralnym branchu za pomocą komnedy `git stash branch <brnch_name>`

```
git clean
```
Oczyszcza repozytorium z nieśledzonych (untracked) plików.

```
git commit --amend
```
Nadpisuje ostatni komit - użyteczne jeśli chcemy zmienić komentarz do komita. Uwaga: nie dotyczy komitów, które już poszły na zdalne repo.

## [Książka GIT](https://git-scm.com/book/en/v2/Getting-Started-Getting-Help) - notatki

```
git add -h
```
W ten sposób wyświetlamy zwięzły opis danej metody (tu: `git add`). Alternatywą jest `git help add` lub `git add --help`, co wyświetla pełną pomoc.
```
git config -l --show-origin
```
Wyświetla wszystkie ustawienia gita oraz w jakich plikach jest dane ustawienie zdefiniowane

### Historia komitów

Polecenie `git log` pozwala na przeglądanie historii komitów. Posiada ona wiele opcji, takich jak:
```
--patch -p #pozwala na wyświetlanie zmian dokonancyh w danym pliku w danym komicie
--pretty=[oneline|full|fuller|format:"..."] #zmiana sposobu wyświetlania komitów, format dodatkowo posiada swoje opcje, jest on najbardziej elastyczny
--graph #wyświetla graf, który wizualizuje branche i komity na nich robione.
```
Poniższe opcje pozwalają ograniczyć historię.
```
--since --after  # komity po dacie, np.: --since="2018-05-05"
--until --before # komity przed datą
-<n>  # ilość komitów wstecz, np. -6
--grep # pozwala zdefiniować jaki podciąg ma zawierać komentarz komita
-S  # tekst, który ma zawierać zmieniony plik (tylko tekst, który został zmieniony, tzn. dodany/usunięty)
--committer # komitujący
--author #auto zmian komitowanych (może być różny od komitującego)
--no-merges  # pomija komity, które zawierały merge
```

### Cofanie zmian

`git commit --amend` nadpisuje ostatni komit.

`git reset` - wycofuje zmiany z indeksu (staged), ale pliki pozostają zmienione lokalnie, ale nie w indeksie

`git checkout` - cofa zmiany zroibione lokalnie, tzn. nie wrzucone jeszcze do indeksu

### Zdalne serwery

Domyślnie, GIT tworzy jedno zdalne repo pod nazwą `origin` dla serwera, z którego sklonowaliśmy repozytorium. Opcja `remote` pozwala pracować ze zdalnymi serwerami:

`git remote` wyświetla nazwy wszystkich serwerów

`git remote -v` - dodatkowo wyśiwetla jeszcze URL do fetcha i pusha

`git remote add <name> <url>` - dodaje nowy serwer zdalnego repozytorium

`git remote show <name>` - wyświetla stan zdalnego repo (np. branche zdalne)

Inne:
```
git remote rename <name> <newname>
git remote remove <name>
```

### Gałęzie

`HEAD` jest wskaźnikiem gałęzi, na której obecnie się anjdujemy.

`git log --all` wyświetla historię ze wszystkich branchy.

`git log <branchname>` pokazuje historię danej gałęzi.

## `git rebase`

Polecenie `rebase` pozwala nam na zachowanie komitów na aktualnym branchu na górze przy mergowaniu, tzn. jesli mamy sytuajcę, gdzie historie branchy się rozjądą:
```
           branch
            ↓
       C4 - C5
      /
C1 - C2 - C3
           ↑
          master
```
to mergując mastera, to historia będzie taka, że wpierw będą nasze komity, mastera, a następnie komit mergowy (czyli komit zmergowanych plików). Polecenie `rebase` sprawia, że ta historia jest inna: wpierw są komity z mastera, a następnie z brancha.

Jeśli przy mergowaniu z rebasem wystąpią konflikty, to po ich rozwiązaniu należy wykonać polecneie `git rebase --continue` lub `git rebase --abort`. Jednak możemy o tym zapomnieć, wówczas `git status` wyświetla nam obecny status brancha, razem informacją na temat jakiegokolwiek procesu rebase.

### Ustawianie zdalnych serwerów

Aby założyć zdalne repozytorium, wpierw należy mieć działające lokalne repozytorium. Na przykład `C:\git_repo`, wówczas, aby założyć repozytorium zdalne wystarczy wykonać polecenie
```
git clone --bare C:\git_repo C:\some_safe_directory\my_remote_repo
```
Od tego momentu lokalizację możemy ustawiać `C:\some_safe_directory\my_remote_repo` jako `remote` dla naszych lokalnych repozytoriów. Jeśli chcemy dane repo zdalne wynieść gdzieś na serwer, aby więcej osób mogło na nim pracować, przenosimy skopiowane zdalne repo na serwer i tam wykonujemy komendę (w utworzonej lokalizacji):
```
git init --bare
```
Dodatkowo należy ustalić protokół, po którym odbywać się będzie komunikacja z gitem. GIT obsługuje `SSH`, `https` oraz ma własny protokół `git`.