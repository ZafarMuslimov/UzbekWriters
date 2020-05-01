package com.example.uzbekwriters


import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.listener.*

class PdfFragment : Fragment() {

    lateinit var pdfView: PDFView
    lateinit var progressBar: ProgressBar
    lateinit var asar: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_pdf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pdfView = view.findViewById(R.id.pdf_viewer)
        progressBar = view.findViewById(R.id.progress_bar)
//        if (intent != null)
//        {
//            val viewType = intent.getStringExtra("ViewType")
//            if (viewType != null || TextUtils.isEmpty(viewType))
//            {
//                if (viewType == "assets")
//                {
                    asar = arguments?.getString("asar").toString()
                    pdfView.fromAsset(asar + ".pdf")
                            .password(null)//enter password if PDF is password protected
                            .defaultPage(0)//set the default page
                            .enableSwipe(true)//enable the swipe to change page
                            .swipeHorizontal(false)//set horizontal swipe to false
                            .enableDoubletap(true)//double tap to zoom
                            .onDraw(object: OnDrawListener {
                                override fun onLayerDrawn(canvas: Canvas, pageWidth:Float, pageHeight:Float, displayedPage:Int) {
                                }
                            })
                            .onDrawAll(object: OnDrawListener {
                                override fun onLayerDrawn(canvas:Canvas, pageWidth:Float, pageHeight:Float, displayedPage:Int) {
                                }
                            })
                            .onPageError(object: OnPageErrorListener {
                                override fun onPageError(page:Int, t:Throwable) {
//                                    Toast.makeText(this@ViewActivity, "Error", Toast.LENGTH_LONG).show()
                                }
                            })
                            .onPageChange(object: OnPageChangeListener {
                                override fun onPageChanged(page:Int, pageCount:Int) {
                                }
                            })
                            .onTap(object: OnTapListener {
                                override fun onTap(e: MotionEvent):Boolean {
                                    return true
                                }
                            })
                            .onRender(object: OnRenderListener {
                                override fun onInitiallyRendered(nbPages:Int, pageWidth:Float, pageHeight:Float) {
                                    pdfView.fitToWidth()
                                }
                            })
                            .enableAnnotationRendering(true)
                            .invalidPageColor(Color.WHITE)
                            .load()
//                }
//            }
//        }

    }
}
