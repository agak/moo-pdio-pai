function a=backtk(cond,a0,x,p,c,f0,f1,rho)
% Algorytm backtrackingu - poszukiwanie d�ugo�ci kroku spe�niaj�cej
% kryterium
% INPUT:
%       cond - nazwa kryterium
%       a0 - pocz�tkowa d�ugo�� kroku
%       x - aktualne przybli�enie
%       p - kierunek poszukiwania
%       c - sta�a u�ywana w kryterium
%       f0-funkcja podstawowa f(Rn)->R
%       f1-gradient funkcji podstawowej f(Rn)->Rn
%       rho - mno�nik u�ywany w algorytmie (0,1)
% OUTPUT:
%       a - d�ugo�� kroku dla kt�rej zachodzi kryterium
switch cond
    case 'armijo'
        check=@(a)armijo(a,x,p,c,f0,f1);
    case 'goldstein'
        check=@(a)goldstein(a,x,p,c,f0,f1);
    case 'wolfe'
        check=@(a)wolfe(a,x,p,c,f1);
    case 'wolfes'
        check=@(a)wolfes(a,x,p,c,f1);
end
a=a0;
while check(a)==0  %poszukiwanie d�ugo�ci kroku dla kt�rej
                   %zachodzi� b�dzie dane kryterium
    a=rho*a;
end
    