.class Lcom/lewish/start/andfixdemo/MainActivity$1_CF;
.super Ljava/lang/Object;
.source "MainActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/lewish/start/andfixdemo/MainActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/lewish/start/andfixdemo/MainActivity;


# direct methods
.method constructor <init>(Lcom/lewish/start/andfixdemo/MainActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/lewish/start/andfixdemo/MainActivity;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/lewish/start/andfixdemo/MainActivity$1_CF;->this$0:Lcom/lewish/start/andfixdemo/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .annotation runtime Lcom/alipay/euler/andfix/annotation/MethodReplace;
        method = "onClick"
        clazz = "com.lewish.start.andfixdemo.MainActivity$1"
    .end annotation

    .prologue
    .line 38
    const-string v0, "\u4fee\u590d\u8fc7\u7684App"

    .line 39
    .local v0, "text":Ljava/lang/String;
    iget-object v1, p0, Lcom/lewish/start/andfixdemo/MainActivity$1_CF;->this$0:Lcom/lewish/start/andfixdemo/MainActivity;

    const/4 v2, 0x0

    invoke-static {v1, v0, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 40
    return-void
.end method
