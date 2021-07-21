from burst import*
import sys
import math

#def next_exp():
    
class Rand48(object):
    def __init__(self, seed):
        self.n = seed

    def seed(self, seed):
        self.n = seed

    def srand(self, seed):
        self.n = (seed << 16) + 0x330e

    def next(self):
        self.n = (25214903917 * self.n + 11) & (2 ** 48 - 1)
        return self.n

    def drand(self):
        return self.next() / 2 ** 48

def next_exp(seed, Lambda, upper):
    rand = Rand48(seed)
    while(True):
        r = rand.drand()
        x = -math.log(r)
        if x <= upper:
            return math.floor(x/Lambda)
    
        


# argv[1]: Define n as the number of processes to simulate
# argv[2]: seed for the random number generator
# argv[3]: parameter λ, 1/λ will be the average random value generated
# argv[4]: upper bound for valid pseudo-random numbers 
# argv[5]: Define t_cs as the time, in milliseconds, that it takes to perform a context switch. Expect tcs
#           to be a positive even integer.
# argv[6]: For the SJF and SRT algorithms, the constant α
# argv[7]: For the RR algorithm, define the time slice value, t_slice, measured in milliseconds
if __name__ == '__main__':
    processID = ['A','B','C','D','E','F','G','H','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z']
    processes = []
    
    if sys.argc != 8:
        raise Exception("invalid args number")
    process_num = sys.argv[1]
    seed = sys.argv[2]
    Lambda = sys.argv[3]
    upper_bound = sys.argv[4]
    t_cs = sys.argv[5]
    alpha = sys.argv[6]
    t_slice = sys.argv[7]
    rand = Rand48(seed)
    for i in range(process_num):
        arrival = next_exp(seed, Lambda, upper_bound)
        CPU_burst = math.ceil(rand.drand * 100)
        process = Burst(processID[i], arrival, )
        processes.append(process)
        