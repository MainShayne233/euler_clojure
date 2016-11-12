(defn divisible_by? [x d] (= (mod x d) 0))

(defn check_prime [x d]
  (cond
    (> (* d d) x) true
    (divisible_by? x d) false
    :else (check_prime x (+ d 1))
  )
)

(defn is_prime? [x]
  (case (< x 2)
    true false
    false (check_prime x 2)
  )
)

(defn assoc_or_inc [map key]
  (cond
    (= (get map key) nil) (assoc map key 1)
    :else (update map key inc)
  )
)

(defn next_prime [prime]
  (cond
    (is_prime? (+ prime 1)) (+ prime 1)
    :else (next_prime (+ prime 1))
  )
)

(defn get_primes [x map prime]
  (cond
    (= x 1) map
    (divisible_by? x prime) (get_primes (/ x prime) (assoc_or_inc map prime) prime)
    :else (get_primes x map (next_prime prime))
  )
)

(defn prime_factorization [x]
  (get_primes x {} 2)
)

(defn prime_factors [x]
  (into [] (keys (prime_factorization x)))
)

(defn largest_prime_factor [x]
  (apply max
    (prime_factors x)
  )
)

(println
  (largest_prime_factor 600851475143)
)
