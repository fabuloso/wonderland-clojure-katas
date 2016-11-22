(ns alphabet-cipher.coder)

(defn char-int [letter]
  (int letter)  
  )

(defn int-char [number]
  (char number)
  )

(defn distance [letter]
   (- 
     (int letter) 
     (int \a))
   )

(defn single-letter-work [first second]
 (+ 
   (- (int second) 97) 
    (distance first))
 ) 

(defn cipher-single-char [letter base]
  (char 
    (+
      (rem (single-letter-work letter base) 26) 
    97))
  ) 

(defn fix-keyword [keyword length]
  (take length (apply concat (repeat keyword)))
  )

(defn distance-bewtween [first second]
  (- (int second) (int first)))
   
(defn distances [keyword message]
  (map distance-bewtween message keyword))

(defn encode [keyword message]
  (apply str 
         (map cipher-single-char 
              (char-array message) 
              (char-array 
                (fix-keyword keyword 
                             (count message )))))
  )

(defn decode [keyword message]
  (apply str (map char
         (map #(+ 97 %) (distances keyword message))))
  )

(defn decipher [cipher message]
  "decypherme")

