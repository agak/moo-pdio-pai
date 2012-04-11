function test=armijo(a,x,p,c,f0,f1)
% funkcja sprawdza czy dla zadanej d�ugo�ci kroku zachodzi kryterium armijo
% INPUT:
%       a-aktualna d�ugo�c kroku [n]
%       x-aktualne przybli�enie [n;...]
%       p-kierunek poszukiwania [n;...]
%       c-sta�a wykorzystywana w kryterium (0,1)
%       f0-funkcja podstawowa f(Rn)->R
%       f1-gradient funkcji podstawowej f(Rn)->Rn
% OUTPUT:
%       test - prawda/fa�sz, czy warunek zachodzi

if f0(x+a*p)<=f0(x)+c*a*f1(x)'*p
    test=1;
else 
    test=0;
end
end