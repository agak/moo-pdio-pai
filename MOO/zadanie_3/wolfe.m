function test=wolfe(a,x,p,c,f1)
% funkcja sprawdza czy dla danej d�ugo�ci kroku zachodzi s�abe kryterium wolfa
% INPUT:
%       a-aktualna d�ugo�c kroku [n]
%       x-aktualne przybli�enie [n;...]
%       p-kierunek poszukiwania [n;...]
%       c-sta�a wykorzystywana w kryterium (0,1), powinna by� wi�ksza od
%       tej u�ytej w armijo
%       f0-funkcja podstawowa f(Rn)->R
%       f1-gradient funkcji podstawowej f(Rn)->Rn
% OUTPUT:
%       test - prawda/fa�sz, czy warunek zachodzi

if c*f1(x)'*p<=f1(x+a*p)'*p
    test=1;
else 
    test=0;
end
end