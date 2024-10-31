package zip.learn.animals

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Context
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.view.isVisible
import androidx.viewpager.widget.PagerAdapter
import com.wajahatkarim3.easyflipviewpager.CardFlipPageTransformer
import zip.learn.animals.databinding.ViewFlipCardBinding

class FlipCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var _binding: ViewFlipCardBinding? = ViewFlipCardBinding.inflate(LayoutInflater.from(context), this)
    private val binding: ViewFlipCardBinding
        get() = requireNotNull(_binding)

    private lateinit var cardModel: CardModel
    private var pagerAdapter: PokerPagerAdapter? = null
    private var listener: ((String) -> Unit)? = null

    fun bindLayout(cardModel: CardModel, listener: ((String) -> Unit)?) {
//        if (::cardModel.isInitialized) {
//            throw IllegalAccessException("Cannot update cardModel")
//        }
        this.cardModel = cardModel
        this.listener = listener
        bindLayout()
        unlock()
    }

    private fun bindLayout() {
        pagerAdapter = PokerPagerAdapter(context)
        binding.viewPager.adapter = pagerAdapter!!

        val cardFlipPageTransformer = CardFlipPageTransformer()
        cardFlipPageTransformer.isScalable = false
        cardFlipPageTransformer.flipOrientation = CardFlipPageTransformer.VERTICAL
        binding.viewPager.setPageTransformer(true, cardFlipPageTransformer)
    }

    fun getCardId(): String? {
        if (::cardModel.isInitialized.not()) return null
        return cardModel.cardId
    }

    inner class PokerPagerAdapter(context: Context) : PagerAdapter() {
        private var mLayoutInflater: LayoutInflater = LayoutInflater.from(context)
        private var pages: ArrayList<Any> = ArrayList()

        init {
            pages.add(Any())
            pages.add(Any())
        }

        override fun getCount(): Int {
            return pages.size
        }

        override fun isViewFromObject(view: View, `object`: Any): Boolean {
            return view === `object`
        }

        // This method should create the page for the given position passed to it as an argument.
        override fun instantiateItem(container: ViewGroup, position: Int): Any {
            val rootView: View = mLayoutInflater.inflate(R.layout.card_image_layout, container, false)
            val imgCardSide = rootView.findViewById<AppCompatImageView>(R.id.imgCardSide)
            imgCardSide.setOnClickListener {
                if (isLockTap) return@setOnClickListener
                if (position == 0) {
                    binding.viewPager.setCurrentItem(1, true)
                    listener?.invoke(cardModel.cardId)
                }
//                else {
//                    binding.viewPager.setCurrentItem(0, true)
//                }
            }
            val sides = intArrayOf(cardModel.frontId, cardModel.backsideId)
            imgCardSide.setImageResource(sides[position])
            container.addView(rootView)
            return rootView
        }

        // Removes the page from the container for the given position.
        override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
            container.removeView(`object` as View)
        }
    }

    fun hideCard() {
        binding.viewPager.setCurrentItem(0, true)
    }

    private var isLockTap: Boolean = false

    fun lock() {
        isLockTap = true
    }

    fun unlock() {
        isLockTap = false
    }

    fun exaclty() {
        isLockTap = true
    }

    fun onDestroyView() {
        pagerAdapter = null
        _binding = null
    }
}
