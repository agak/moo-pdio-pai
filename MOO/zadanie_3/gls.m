function x=gls(x0,fn,a0,rho,c,kMax, eps)
% Metoda najszybszego spadku
% INPUT:
%       x0 - punkt pocz�tkowy;
%       sl - nazwa kryterium;
%       f0 - funkcja podstawowa napis(np 'X^2+Y^2')   
%       a0 - pocz�tkowa d�ugo�c kroku;
%       rho - parametr backtrackingu
%       c - sta�a wykorzystywana w kryteriach
% OUTPUT:
%       x - rozwi�zania;



%ugotuj funkcje podstawow� z stringa
f=inline(fn);
f0=@(x)f(x(1),x(2));

%ugotuj gradien na podstawie przepisu w stringu
syms x y
t=[x;y];
w=fn;
gfn=matlabFunction(jacobian(w,t).');
f1=@(x)gfn(x(1),x(2)); %gradient funkcji w punkcie

sl='wolfe';
%wybor kryterium
sl=@(x,d)backtk(sl,a0,x,d,c,f0,f1,rho);
x=x0;
k=0;

Sk = eye(length(x0), length(x0));
err = 1.0;
X=x(1);
Y=x(2);
fk=0;
while (k<kMax) %&& (eps < err) %warunek zako�czenia, liczba iteracji lub d�ugo�� kroku
    %kierunek
    %p=-f1(x);
    g = f1(x);
    d = -Sk*g;
    %d�ugo�� kroku spe�niaj�ca kryterium
    a=sl(x,d);
    %kolejne przybli�enie
    fk = f0(x);
    x=x+a*d;
    fprintf('f(%.3f,%.3f)=%.3f\n',x(1),x(2),fk);
    X=horzcat(X, x(1));
    Y=horzcat(Y, x(2));
    fk_new = f0(x);
    p = a*d;
    q= f1(x) - g;
    Sk = Sk + (p*(p'))/(p'*q) - (Sk*q*(q')*Sk)/(q'*(Sk*q)); %kolejne przybli�enie hesjanu
    %s� bardziej optymalne sposoby obliczania tego przybli�enia - tzn
    %optymalizacje tej metody, nawet znalaz�em pdfa w kt�ym s� podane i
    %por�wnane, ale jednak wyrost formy nad tre�ci� by by� niepotrzebny :)
    %licznik iteracji
    k=k+1;
    %b��d
    err = max( abs(fk - fk_new),norm(p));
end


fplot (fn,X, Y)
%Przyk�ady
%gls([2;2],'wolfes','x^2+y^2',0.5,0.3,[0.8;0.5],10,0.001)

     
     