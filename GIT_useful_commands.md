Exclude file TestClass.cs from cleaning
```
git clean -dfX --exclude="!TestClass.cs"
```
Reverting particular files to particular commit/revision
```
git checkout <commit hash> -- file/to/restore anotherfile/to/restore
```
