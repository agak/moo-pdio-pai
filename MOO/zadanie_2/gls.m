function x=gls(x0,sl,fn,a0,rho,c)
% Metoda najszybszego spadku
% INPUT:
%       x0 - punkt pocz�tkowy;
%       sl - nazwa kryterium;
%       f0 - funkcja podstawowa napis(np f0=@(x)x(1)^2+y(2)^2)   
%       a0 - pocz�tkowa d�ugo�c kroku;
%       rho - parametr backtrackingu
%       c - sta�a wykorzystywana w kryteriach
% OUTPUT:
%       x - rozwi�zania;


syms x y
%ugotuj funkcje podstawow� z stringa
f=inline(fn);
f0=@(x)f(x(1),x(2));

%ugotuj gradien na podstawie przepisu w stringu
t=[x;y];
w=fn;
gfn=matlabFunction(jacobian(w,t).');
f1=@(x)gfn(x(1),x(2));

%wybor kryterium
sl=@(x,p)backtk(sl,a0,x,p,c,f0,f1,rho);
x=x0;
k=0;

while k<10 %warunek zako�czenia, liczba iteracji
    %kierunek
    p=-f1(x);
    %d�ugo�� kroku spe�niaj�ca kryterium
    a=sl(x,p);
    %kolejne przybli�enie
    x=x+a*p
    %licznik iteracji
    k=k+1;
end
%Przyk�ady
%gls([2;2],'armijo',@(x)x(1)^2+x(2)^2,0.36,0.5,0.2)
%gls([2;2],'wolfes',@(x)x(1)^2+x(2)^2,0.35,0.5,[0.8;0.5])
%gls([2;2],'wolfes',@(x)x(1)^2+x(2)^2,0.35,0.5,[0.8;0.5])
%gls([2;2],'goldstein',@(x)x(1)^2+x(2)^2,0.35,0.5,0.2)
     
     