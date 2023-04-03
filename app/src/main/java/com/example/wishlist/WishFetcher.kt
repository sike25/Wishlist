package com.example.wishlist

class WishFetcher {

    companion object {
        val names = listOf("Pistachio Ice-Cream", "iPhone 14 Pro Max", "Red Casual Dress", "Air-King Rolex", "Lock Bangle", "Gourmet Spicy Ramen", "Orange Linen Jumpsuit", "Nike Air Force 1 '07 LX", "Maduritos", "L'Oreal Mascara", "J", "K", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        val prices = listOf("$90.3", "$999", "$13.99", "$7,450", "$14,000", "$22.21", "$49.9", "$89.97", "$12.09", "$14.99")
        val urls = listOf("https://www.walmart.com/ip/Villa-Dolce-Pure-Sicilian-Pistachio-Gelato-5-Liter-1-each/229566297",
                           "https://www.apple.com/iphone-14/?afid=p238%7CsEFLNwnV8-dc_mtid_20925d2q39172_pcrid_649435389264_pgrid_140971852237_pntwk_g_pchan__pexid__&cid=wwa-us-kwgo-iphone--slid---Brand-iPhone14--",
                           "https://www.thredup.com/product/women-polyester-nude-red-casual-dress/132891396",
                           "https://www.rolex.com/watches/air-king/m126900-0001.html",
                           "https://www.tiffany.com/jewelry/bracelets/tiffany-lock-bangle-GRP12069/",
                           "https://www.amazon.com/NongShim-Ramyun-Noodle-Gourmet-Spicy/dp/B00778B90S",
                           "https://www.zara.com/us/en/100-linen-short-jumpsuit-p08016500.html?v1=231877475",
                           "https://www.nike.com/t/air-force-1-07-womens-shoes-wqlbRX/DV3809-100",
                           "https://www.amazon.com/Iberia-Naturally-Sweet-Plantain-Chips/dp/B081LW6MWQ/ref=asc_df_B081LW6MWQ/?tag=hyprod-20&linkCode=df0&hvadid=459578039738&hvpos=&hvnetw=g&hvrand=2393172153701551485&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=9001635&hvtargid=pla-942644564769&psc=1",
                           "https://www.cvs.com/shop/l-oreal-paris-telescopic-lift-washable-makeup-mascara-prodid-5370024?skuId=302532&cgaa=QWxsb3dHb29nbGVUb0FjY2Vzc0NWU1BhZ2Vz&cid=ps_ecomm_priosku_pla&gclid=Cj0KCQiA6fafBhC1ARIsAIJjL8mQsiLkWVKzFHBDuFv3bkSQgGQcCEpaAleweuchNRA0pMWOkjaJJk4aAvzYEALw_wcB&gclsrc=aw.ds",
                           "k")

        fun getWishes(): MutableList<Wish> {
            var wishes : MutableList<Wish> = ArrayList()
            for (i in 0..9) {
                val email = Wish(names[i], prices[i], urls[i])
                wishes.add(email)
            }
            return wishes
        }

        fun getNext5Wishes(): MutableList<Wish> {
            var newWishes : MutableList<Wish> = ArrayList()
            for (i in 10..14) {
                val email = Wish(names[i], prices[i], urls[i])
                newWishes.add(email)
            }
            return newWishes
        }
    }


}