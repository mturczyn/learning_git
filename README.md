# branches_tests

Początkowo miało być to repozytorium do nauki pracy z branchami na gicie, jednak w miarę pracy, przerodziło się w szerzej pojętą naukę GITa. Poniżej zbiór notatek z tego kursu.

Pliki z tego repozytorium są wyłącznie w celach testowych, nie stanowią żadnego projektu, ani aplikacji.

Źródła:
- [książka na stronie GIT](https://git-scm.com/book/en/v2/Getting-Started-Getting-Help)

# Rebasing

[This link](http://git-scm.com/docs/git-rebase#_interactive_mode) contains rebasing manual.

In order to rebase our branch and adjust commits before merging with main branch, we need to:

1. Execute `git rebase -i develop` where `develop` is branch we want to merge into. This will allow us to adjust what commits we want to take/abandon/etc. FOr example we might want to squash all commits into one.

2. Fill correctly the message asked by GIT.

3. Force push to remote, as it must overwrite history: `git push -f`. Now our history (local and remote) should show only adjusted commits (if we wanted to squash into 1, it should show this 1 commit).

# Default editor for GIT

Sometimes, after executing GIT command that needs text input, GIT opens up default text editor to enter needed data (commit message for example). In order to switch to more convenient tool we can use command:
```
git config --global core.editor "'C:/Program Files/Notepad++/notepad++.exe' -multiInst -notabbar -nosession -noPlugin"
```