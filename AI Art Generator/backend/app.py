import torch , numpy,pandas,matplotlib,torch,flask
from importlib.metadata import version
for pkg in ("numpy", "pandas", "matplotlib", "torch", "flask"):
    print(pkg, version(pkg))
