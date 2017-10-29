#########################################################
order.of.growth <- function(x){
  n = seq(0, x, by = 0.1)
  plot(n, log(n), col = 1, type = "l", 
       main = "Order of Growth",
       ylim = c(0,max(n*n)))
  grid()
  lines(n, n, col = 2, type = "l")
  lines(n, n*log(n), col = 3, type = "l")
  lines(n, n*n, col = 4, type = "l")  
  #lines(n, 2^n, col = 5, type = "l")  
  legend("topleft", c("log(n)", "n", "n*log(n)","n*n"), col = 1:5,lty = 1)
}
order.of.growth(30)
#########################################################
sandiwich <- function(n, fn, c1gn, c2gn){
  plot(n, fn, col = "blue", type = "l", 
       main = "fn is saniwiched between c1gn and c2gn"
       #ylim = c(0,max(fn))
       )
  grid()
  lines(n, c1gn, col = "red", type = "l")
  lines(n, c2gn, col = "red", type = "l")  
}
#########################################################
n = seq(0, 50, by = 0.1)
fn = 3*n + 10
c1gn = 2*n
c2gn = 4*n

sandiwich(n, fn, c1gn, c2gn)
#########################################################
n = seq(0, 40, by = 0.1)
fn = 3*n*log(n) + 20*n  + 3
gn = n*log(n)

c1gn = 2*gn
c2gn = 4*gn

sandiwich(n, fn, c1gn, c2gn)

